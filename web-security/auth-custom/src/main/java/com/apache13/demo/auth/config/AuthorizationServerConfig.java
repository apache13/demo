package com.apache13.demo.auth.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;

	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("client")
				.secret(passwordEncoder().encode("password"))
				.authorizedGrantTypes("password", "refresh_token")
				.scopes("openid")
				.accessTokenValiditySeconds(600)
				.refreshTokenValiditySeconds(1200);
	}

	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new CustomAccessTokenConverter();
		// converter.setSigningKey("12345");
		KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("jwt/jwt.p12"), "password".toCharArray())
				.getKeyPair("jwt", "password".toCharArray());
		converter.setKeyPair(keyPair);
		return converter;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationConfiguration.getAuthenticationManager()).tokenStore(tokenStore())
				.accessTokenConverter(accessTokenConverter()).userDetailsService(userDetailsService)
				.pathMapping("/oauth/token", "/auth/realms/master/protocol/openid-connect/token");
	}

}

package com.wealth.bwm2.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;

@Configuration
public class AuthorizationServerConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	@Primary
	public AuthorizationServerEndpointsConfiguration authorizationServerEndpointsConfiguration() {
		AuthorizationServerEndpointsConfiguration authorizationServerEndpointsConfig = new AuthorizationServerEndpointsConfiguration();
		authorizationServerEndpointsConfig.getEndpointsConfigurer().userDetailsService(userDetailsService);
		return authorizationServerEndpointsConfig;
	}

}

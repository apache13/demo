package com.apache13.demo.auth.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomAccessTokenConverter extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();
		info.put("iss", "iss");
		info.put("sub", "sub");
		info.put("user_id", 1);
		info.put("option", new HashMap<String, Object>() {{put("other_id",99);}});		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return super.enhance(accessToken, authentication);
	}
}

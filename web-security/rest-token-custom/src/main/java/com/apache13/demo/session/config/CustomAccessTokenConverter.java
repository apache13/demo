package com.apache13.demo.session.config;

import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomAccessTokenConverter extends JwtAccessTokenConverter {

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		OAuth2Authentication auth = super.extractAuthentication(map);
		auth.setDetails(map);
		return auth;
	}
}

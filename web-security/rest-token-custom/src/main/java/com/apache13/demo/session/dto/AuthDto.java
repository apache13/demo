package com.apache13.demo.session.dto;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class AuthDto {
	private String tokenValue;
	private String tokenType;
	private String name;
	private Map<String, Object> payload;

	private Authentication authentication;

	public AuthDto(Authentication authentication) {
		Object details = authentication.getDetails();
		if (details instanceof OAuth2AuthenticationDetails) {
			OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) details;
			this.tokenValue = oAuth2AuthenticationDetails.getTokenValue();
			this.tokenType = oAuth2AuthenticationDetails.getTokenType();
			this.payload = (Map<String, Object>) oAuth2AuthenticationDetails.getDecodedDetails();
		}
		this.name = authentication.getName();
		//this.authentication = authentication;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}

}

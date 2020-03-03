package com.apache13.demo.session.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class AuthDto {
	private String tokenValue;
	private String tokenType;
	private String name;
	private Map<String, Object> payload;
	private Collection<? extends GrantedAuthority> grantedAuthorities;

	public AuthDto(Authentication authentication) {
		if (authentication != null) {
			if (authentication instanceof OAuth2Authentication) {
				OAuth2Authentication oauth2 = (OAuth2Authentication) authentication;
				this.name = oauth2.getName();
				this.grantedAuthorities = oauth2.getAuthorities();

				if (authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
					OAuth2AuthenticationDetails oauth2Details = (OAuth2AuthenticationDetails) authentication
							.getDetails();
					this.tokenValue = oauth2Details.getTokenValue();
					this.tokenType = oauth2Details.getTokenType();
					this.payload = (Map<String, Object>) oauth2Details.getDecodedDetails();
				}
			}
		}
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

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(Collection<? extends GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

}

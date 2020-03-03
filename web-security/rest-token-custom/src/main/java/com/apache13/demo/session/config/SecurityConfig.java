package com.apache13.demo.session.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.sessionManagement()
		.sessionFixation().newSession()
		//.sessionFixation().migrateSession()
		.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.and()
		.authorizeRequests()
		.antMatchers("/api/admin").authenticated()
		.anyRequest().permitAll()		
		.and()		
		.httpBasic();
	}
}

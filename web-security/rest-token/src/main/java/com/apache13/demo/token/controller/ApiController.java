package com.apache13.demo.token.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apache13.demo.token.dto.AuthDto;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping(value = "/anonymous")
	public AuthDto anonymous(Authentication authentication) {
		return new AuthDto(authentication);
	}

	@GetMapping(value = "/admin")
	public AuthDto admin(Authentication authentication) {
		return new AuthDto(authentication);
	}

}

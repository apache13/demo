package com.wealth.bwm2.auth.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wealth.bwm2.auth.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping(value = "/users")
	public List<UserDto> getUser() {
		return new ArrayList<UserDto>(Arrays.asList(new UserDto(1, "A"), new UserDto(2, "B")));
	}
}

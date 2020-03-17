package com.apache13.demo.blocking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apache13.demo.blocking.service.GreetService;

@RestController
@RequestMapping("/api")
public class GreetController {

	@Autowired
	private GreetService greetService;

	@GetMapping("/greet")
	public String greeting() {
		return greetService.greeting();
	}

	@GetMapping("/greet2")
	public String greeting2() throws InterruptedException {
		return greetService.greetingWithDelay();
	}
}

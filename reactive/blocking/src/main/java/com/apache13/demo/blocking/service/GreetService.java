package com.apache13.demo.blocking.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetService {

	@Autowired
	private GreetService greetService;

	public String greeting() {
		return "Greeting in thread " + Thread.currentThread().getId();
	}

	public String greetingWithDelay() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		return "Greeting in thread " + Thread.currentThread().getId();
	}
}

package com.apache13.demo.nonblocking.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class GreetService {
	public String greeting() {
		return "Greeting in thread " + Thread.currentThread().getId();
	}

	public Mono<String> greetingWithMonoAndDelay() throws InterruptedException {
		return Mono.just("Greeting in thread " + Thread.currentThread().getId()).delayElement(Duration.ofSeconds(1));
	}
}

package com.apache13.demo.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WvcApplication.class, args);
	}

}

package com.apache13.demo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.apache13.demo.data.repository.CustomerRepository;
import com.apache13.demo.data.repository.RmRepository;

@SpringBootApplication
public class TemporalFactTablesApplication {

	@Autowired
	private RmRepository rmRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(TemporalFactTablesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			rmRepository.findAll().forEach(System.out::println);
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}

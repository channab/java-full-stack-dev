package com.javafullstackdev.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("say Hello method called.");
		return "Hello from Java Full Stack Dev";
	}
}

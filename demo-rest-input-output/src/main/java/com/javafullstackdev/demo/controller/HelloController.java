package com.javafullstackdev.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackdev.demo.model.Greeting;

@RestController
public class HelloController {

	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello "+ name;
	}
	
	@GetMapping("/hello")
	public String sayHelloQueryParam(@RequestParam("name") String name) {
		return "Hello "+ name;
	}
	
	@PostMapping("/hello")
	public Greeting sayHelloJsonRequestResponse(@RequestBody String name) {
		return new Greeting("Hello " + name, "https://www.javafullstackdev.com");
	}
}

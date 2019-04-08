package com.javafullstackdev.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoCrudMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudMysqlApplication.class, args);
	}

}

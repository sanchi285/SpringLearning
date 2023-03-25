package com.mongodbtest.mongodbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MongodbtestApplication {
	public static void main(String[] args) {
		SpringApplication.run(MongodbtestApplication.class, args);
	}
}

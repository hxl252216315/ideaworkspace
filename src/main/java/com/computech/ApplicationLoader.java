package com.computech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.computech.config",
		"com.computech.service",
		"com.computech.controller",
		"com.computech.mapper"})


public class ApplicationLoader {

	public static void main(String[] args) {

		SpringApplication.run(ApplicationLoader.class, args);
	}
}

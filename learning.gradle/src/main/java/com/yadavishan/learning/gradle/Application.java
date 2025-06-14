package com.yadavishan.learning.gradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yadavishan.learning.httpClient")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

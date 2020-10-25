package com.iscl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class IsclApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsclApplication.class, args);
	}

}

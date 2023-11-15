package com.First_Spring_Project_0323;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FirstSpringProject0323Application {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringProject0323Application.class, args);
	}

}

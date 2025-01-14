package com.revicemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:/profiles/${spring.profiles.active}/application.properties")
public class ReviewMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewMicroserviceApplication.class, args);
		System.out.println("hello review microservice ");
	}

}

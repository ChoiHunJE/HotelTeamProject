package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class HotelV1Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelV1Application.class, args);
	}
	
}

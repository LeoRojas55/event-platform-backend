package com.davivienda.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.davivienda.events.model")
public class EventPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventPlatformApplication.class, args);
	}

}

package com.example.clashroyaledraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClashRoyaleDraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClashRoyaleDraftApplication.class, args);
	}

}

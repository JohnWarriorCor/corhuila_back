package com.corhuila.corhuila;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CorhuilaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorhuilaApplication.class, args);
	}

}

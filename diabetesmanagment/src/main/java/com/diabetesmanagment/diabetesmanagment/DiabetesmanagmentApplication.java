package com.diabetesmanagment.diabetesmanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.diabetesmanagment.diabetesmanagment")
@EnableDiscoveryClient
public class DiabetesmanagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiabetesmanagmentApplication.class, args);
	}

}

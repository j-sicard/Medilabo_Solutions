package com.telusko.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * API Gateway is the entry point for clients to access the services provided by the microservices architecture.
 * It acts as a reverse proxy that routes requests from clients to the appropriate microservices and provides various cross-cutting concerns
 * such as authentication, authorization, rate limiting, load balancing, and logging.
 */
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}

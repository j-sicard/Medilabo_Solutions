package com.eurelaserver.eurekaserveur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server is a service registry and discovery server that enables microservices to locate and communicate with each other.
 * It allows microservices to register themselves and discover other services registered within the same system.
 * Eureka Server plays a crucial role in building resilient and scalable microservices architectures by providing a centralized directory
 * for service registration and discovery, enabling dynamic scaling, load balancing, and failover handling.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaserveurApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserveurApplication.class, args);
	}

}

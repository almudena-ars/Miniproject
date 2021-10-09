package com.ironhack.proxyuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProxyUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyUserServiceApplication.class, args);
	}

}

package com.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProviderSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProviderSystemApplication.class, args);
	}

}


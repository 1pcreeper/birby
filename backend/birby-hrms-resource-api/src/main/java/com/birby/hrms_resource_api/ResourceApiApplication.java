package com.birby.hrms_resource_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ResourceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceApiApplication.class, args);
	}

}

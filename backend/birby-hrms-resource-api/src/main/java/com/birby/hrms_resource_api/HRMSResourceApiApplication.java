package com.birby.hrms_resource_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class HRMSResourceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HRMSResourceApiApplication.class, args);
	}

}

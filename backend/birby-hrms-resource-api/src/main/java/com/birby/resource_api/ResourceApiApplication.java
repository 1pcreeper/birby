package com.birby.resource_api;

import com.birby.resource_api.config.SecurityConfig;
import com.birby.resource_api.properties.FirebaseProperties;
import com.birby.resource_api.properties.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ResourceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceApiApplication.class, args);
	}

}

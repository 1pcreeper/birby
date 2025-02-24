package com.birby.hrms_account_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties
@EnableFeignClients
public class HRMSAccountApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HRMSAccountApiApplication.class, args);
	}

}

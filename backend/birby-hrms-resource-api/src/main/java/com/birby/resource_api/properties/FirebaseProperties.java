package com.birby.resource_api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "firebase-config")
public class FirebaseProperties {
    private String issuerLocation;
    private String claims;
}

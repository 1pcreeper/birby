package com.birby.hrms_resource_api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "firebase-config")
public class FirebaseProperties {
    private String issuerLocation;
    private String rolesClaim;
    private String defaultRegisterEmail;
}

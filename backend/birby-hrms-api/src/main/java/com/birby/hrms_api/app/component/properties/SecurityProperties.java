package com.birby.hrms_api.app.component.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "security-config")
public class SecurityProperties {
    private List<String> allowedCors;
    private String firebaseIssuerLocation;
    private String rolesClaim;
    private String apiKey;
}
package com.birby.hrms_api.app.component.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "firebase-config")
public class FirebaseProperties {
    private String issuerLocation;
    private String rolesClaim;
}

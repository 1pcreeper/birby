package com.birby.hrms_account_api.component.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "security-config")
public class SecurityProperties {
    private List<String> allowedCors;
    private String apiKey;
}

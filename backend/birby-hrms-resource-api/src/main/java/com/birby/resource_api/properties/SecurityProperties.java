package com.birby.resource_api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security-config")
public class SecurityProperties {
    private String allowedCors;

    public String getAllowedCors() {
        return allowedCors;
    }

    public void setAllowedCors(String allowedCors) {
        this.allowedCors = allowedCors;
    }
}

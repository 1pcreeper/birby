package com.birby.hrms_resource_api.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "security-config")
public class SecurityProperties {
    private List<String> allowedCors;
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<String> getAllowedCors() {
        return allowedCors;
    }

    public void setAllowedCors(List<String> allowedCors) {
        this.allowedCors = allowedCors;
    }
}

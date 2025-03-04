package com.birby.hrms_api.component.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "client-config")
public class ClientProperties {
    private String accountUrl;
}
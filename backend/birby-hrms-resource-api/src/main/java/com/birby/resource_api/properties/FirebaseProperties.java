package com.birby.resource_api.properties;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "firebase-config")
public class FirebaseProperties{
    private String issuerLocation;
    private String rolesClaim;

    public String getIssuerLocation() {
        return issuerLocation;
    }

    public void setIssuerLocation(String issuerLocation) {
        this.issuerLocation = issuerLocation;
    }

    public String getRolesClaim() {
        return rolesClaim;
    }

    public void setRolesClaim(String rolesClaim) {
        this.rolesClaim = rolesClaim;
    }
}

package com.birby.hrms_resource_api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
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

package com.birby.hrms_api.component.properties;

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

    public String getRolesClaim() {
        return rolesClaim;
    }

    public void setRolesClaim(String rolesClaim) {
        this.rolesClaim = rolesClaim;
    }

    public String getFirebaseIssuerLocation() {
        return firebaseIssuerLocation;
    }

    public void setFirebaseIssuerLocation(String firebaseIssuerLocation) {
        this.firebaseIssuerLocation = firebaseIssuerLocation;
    }

    public List<String> getAllowedCors() {
        return allowedCors;
    }

    public void setAllowedCors(List<String> allowedCors) {
        this.allowedCors = allowedCors;
    }
}
package com.birby.hrms_account_api.properties;

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

    public String getDefaultRegisterEmail() {
        return defaultRegisterEmail;
    }

    public void setDefaultRegisterEmail(String defaultRegisterEmail) {
        this.defaultRegisterEmail = defaultRegisterEmail;
    }
}

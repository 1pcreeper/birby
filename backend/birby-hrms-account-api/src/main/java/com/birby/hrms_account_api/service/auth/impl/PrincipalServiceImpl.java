package com.birby.hrms_account_api.service.auth.impl;

import com.birby.hrms_account_api.exception.PrincipalException;
import com.birby.hrms_account_api.properties.FirebaseProperties;
import com.birby.hrms_account_api.service.auth.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@EnableConfigurationProperties(FirebaseProperties.class)
public class PrincipalServiceImpl implements PrincipalService {
    private final FirebaseProperties firebaseProperties;

    @Autowired
    public PrincipalServiceImpl(
            FirebaseProperties firebaseProperties
    ) {
        this.firebaseProperties = firebaseProperties;
    }

    @Override
    public Map<String, Object> getPrincipalData(Principal principal) throws PrincipalException {
        Map<String, Object> data = new HashMap<>();
        String roleKey = firebaseProperties.getRolesClaim();
        String uidKey = "uid";

        data.put(uidKey, principal.getName());
        data.put(roleKey, getRolesAsStringList(principal));

        return data;
    }

    @Override
    public List<String> getRolesAsStringList(Principal principal) throws PrincipalException {
        return getRolesClaim(principal);
    }

    @Override
    public boolean hasRoles(Principal principal, List<String> roles) throws PrincipalException {
        Set<String> staffRoles = getRolesClaim(principal).stream().collect(Collectors.toSet());
        Set<String> requiredRoles = roles.stream().collect(Collectors.toSet());
        if (!staffRoles.containsAll(requiredRoles)) {
            return false;
        }
        return true;
    }

    private Object getClaim(Principal principal, String claim) throws PrincipalException {
        try {
            JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
            return token.getTokenAttributes().get(claim);
        } catch (Exception e) {
            throw new PrincipalException("Cannot read the principle");
        }
    }

    private List<String> getRolesClaim(Principal principal) throws PrincipalException {
        try {
            return (List<String>) getClaim(principal, firebaseProperties.getRolesClaim());
        } catch (PrincipalException e) {
            throw new PrincipalException(e.getMessage());
        }
    }
}

package com.birby.hrms_api.app.service.auth.impl;

import com.birby.hrms_api.app.model.exception.PrincipalException;
import com.birby.hrms_api.app.component.properties.SecurityProperties;
import com.birby.hrms_api.app.service.auth.PrincipalService;
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
@EnableConfigurationProperties(SecurityProperties.class)
public class PrincipalServiceImpl implements PrincipalService {
    private final SecurityProperties securityProperties;

    @Autowired
    public PrincipalServiceImpl(
            SecurityProperties securityProperties
    ) {
        this.securityProperties = securityProperties;
    }

    @Override
    public Map<String, Object> getPrincipalData(Principal principal) throws PrincipalException {
        Map<String, Object> data = new HashMap<>();
        String roleKey = securityProperties.getRolesClaim();
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
    public boolean hasRoles(Principal principal, List<String> roleIds) throws PrincipalException {
        Set<String> staffRoles = getRolesClaim(principal).stream().collect(Collectors.toSet());
        Set<String> requiredRoles = roleIds.stream().collect(Collectors.toSet());
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
            return (List<String>) getClaim(principal, securityProperties.getRolesClaim());
        } catch (PrincipalException e) {
            throw new PrincipalException(e.getMessage());
        }
    }
}

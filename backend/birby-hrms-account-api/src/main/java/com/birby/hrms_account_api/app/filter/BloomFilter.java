package com.birby.hrms_account_api.app.filter;

import com.birby.hrms_account_api.app.model.exception.UnAuthorizedException;
import com.birby.hrms_account_api.app.component.properties.FirebaseProperties;
import com.birby.hrms_account_api.app.service.auth.PrincipalService;
import com.birby.hrms_account_api.app.service.manager.BloomFilterManagerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Component
public class BloomFilter extends OncePerRequestFilter {
    private final FirebaseProperties firebaseProperties;
    private final BloomFilterManagerService bloomFilterManagerService;
    private final PrincipalService principalService;
    private final ObjectMapper objectMapper;

    @Autowired
    public BloomFilter(
            BloomFilterManagerService bloomFilterManagerService,
            PrincipalService principalService,
            FirebaseProperties firebaseProperties,
            ObjectMapper objectMapper) {
        this.bloomFilterManagerService = bloomFilterManagerService;
        this.principalService = principalService;
        this.firebaseProperties = firebaseProperties;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Principal principal = request.getUserPrincipal();
        String uid = principal.getName();
        Map<String, Object> principalData = principalService.getPrincipalData(principal);
        List<String> roleIds = objectMapper.convertValue(
                principalData.get(firebaseProperties.getRolesClaim()), new TypeReference<List<String>>() {
                });
        try {
            bloomFilterManagerService.authorize(uid, roleIds);
        } catch (UnAuthorizedException e) {
            response.sendError(403, e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}

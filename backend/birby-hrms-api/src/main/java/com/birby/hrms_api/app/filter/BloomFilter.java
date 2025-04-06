package com.birby.hrms_api.app.filter;

import com.birby.hrms_api.app.component.properties.FirebaseProperties;
import com.birby.hrms_api.app.model.exception.UnAuthorizedException;
import com.birby.hrms_api.app.component.properties.SecurityProperties;
import com.birby.hrms_api.app.service.auth.PrincipalService;
import com.birby.hrms_api.app.service.manager.BloomFilterManagerService;
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
    private final SecurityProperties securityProperties;
    private final BloomFilterManagerService bloomFilterManagerService;
    private final PrincipalService principalService;

    @Autowired
    public BloomFilter(
            FirebaseProperties firebaseProperties,
            SecurityProperties securityProperties,
            BloomFilterManagerService bloomFilterManagerService,
            PrincipalService principalService
    ) {
        this.firebaseProperties = firebaseProperties;
        this.securityProperties = securityProperties;
        this.bloomFilterManagerService = bloomFilterManagerService;
        this.principalService = principalService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        Principal principal = request.getUserPrincipal();
        Map<String, Object> principalData = principalService.getPrincipalData(principal);
        String uid = (String) principalData.get("uid");
        List<String> roleIds = (List<String>) principalData.get(firebaseProperties.getRolesClaim());
        try{
            bloomFilterManagerService.authorize(uid,roleIds,authorization);
        } catch (UnAuthorizedException e) {
            response.sendError(401,e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
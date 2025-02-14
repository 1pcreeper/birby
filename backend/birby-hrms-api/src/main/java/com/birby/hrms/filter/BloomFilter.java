package com.birby.hrms.filter;

import com.birby.hrms.properties.SecurityProperties;
import com.birby.hrms.service.auth.PrincipalService;
import com.birby.hrms.service.cli.AccountStaffRoleCliService;
import com.birby.hrms.service.manager.BloomFilterManagerService;
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
    private final SecurityProperties securityProperties;
    private final BloomFilterManagerService bloomFilterManagerService;
    private final PrincipalService principalService;

    @Autowired
    public BloomFilter(
            SecurityProperties securityProperties,
            BloomFilterManagerService bloomFilterManagerService,
            PrincipalService principalService
    ) {
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
        List<String> roleIds = (List<String>) principalData.get(securityProperties.getRolesClaim());
        bloomFilterManagerService.authorize(uid,roleIds,authorization);
        filterChain.doFilter(request, response);
    }
}
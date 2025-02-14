package com.birby.hrms_account_api.filter;

import com.birby.hrms_account_api.properties.FirebaseProperties;
import com.birby.hrms_account_api.service.auth.PrincipalService;
import com.birby.hrms_account_api.service.manager.BloomFilterManagerService;
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
    @Autowired
    public BloomFilter(
            BloomFilterManagerService bloomFilterManagerService,
            PrincipalService principalService,
            FirebaseProperties firebaseProperties
    ){
        this.bloomFilterManagerService = bloomFilterManagerService;
        this.principalService = principalService;
        this.firebaseProperties = firebaseProperties;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Principal principal = request.getUserPrincipal();
        Map<String,Object> principalData = principalService.getPrincipalData(principal);
        String uid = (String)principalData.get("uid");
        List<String> roleIds = (List<String>)principalData.get(firebaseProperties.getRolesClaim());
        bloomFilterManagerService.authorize(uid,roleIds);
        filterChain.doFilter(request, response);
    }
}

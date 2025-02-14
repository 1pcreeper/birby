package com.birby.hrms.filter;

import com.birby.hrms.bo.response.ResourceAuthResCliBo;
import com.birby.hrms.service.cli.ResourceAuthCliService;
import com.birby.hrms.vo.JwtPrincipal;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final ResourceAuthCliService resourceAuthCliService;
    @Autowired
    public JwtRequestFilter(
            ResourceAuthCliService resourceAuthCliService
    ){
        this.resourceAuthCliService = resourceAuthCliService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
        }
        ResourceAuthResCliBo authData = resourceAuthCliService.getAuthData(jwt);
        JwtPrincipal jwtPrincipal = new JwtPrincipal(
                authData.getStaffId(),
                authData.getToken(),
                authData.getUid(),
                authData.getStaffId(),
                authData.getRoleIds(),
                authData.getEmail()
        );
        SecurityContextHolder.getContext().setAuthentication(new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                for(String roleId : authData.getRoleIds()){
                    grantedAuthorities.add(new GrantedAuthority() {
                        @Override
                        public String getAuthority() {
                            return roleId;
                        }
                    });
                }
                return grantedAuthorities;
            }
            @Override
            public Object getCredentials() {
                return null;
            }
            @Override
            public Object getDetails() {
                return null;
            }
            @Override
            public Object getPrincipal() {
                return jwtPrincipal;
            }
            @Override
            public boolean isAuthenticated() {
                return true;
            }
            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            }
            @Override
            public String getName() {
                return jwtPrincipal.getStaffId();
            }
        });

        filterChain.doFilter(request, response);
    }
}
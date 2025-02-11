package com.birby.hrms.filter;

import com.birby.hrms.dto.response.AuthResCliDto;
import com.birby.hrms.service.cli.ResourceAuthCliService;
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
import java.security.Principal;
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
        AuthResCliDto authData = resourceAuthCliService.getAuthData(jwt);
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
                return new Principal() {
                    @Override
                    public String getName() {
                        return authData.getStaffId();
                    }
                };
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
                return authData.getStaffId();
            }
        });

        filterChain.doFilter(request, response);
    }
}
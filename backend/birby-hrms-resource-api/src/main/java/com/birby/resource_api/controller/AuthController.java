package com.birby.resource_api.controller;

import com.birby.resource_api.dto.ApiResponse;
import com.birby.resource_api.dto.response.AuthResDto;
import com.birby.resource_api.service.auth.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final PrincipalService principalService;
    @Autowired
    public AuthController(
            PrincipalService principalService
    ) {
        this.principalService = principalService;
    }
    @GetMapping()
    public AuthResDto getPrincipal(Principal principal){
        return AuthResDto.builder().principal(principalService.getPrincipalData(principal)).build();
    }
}

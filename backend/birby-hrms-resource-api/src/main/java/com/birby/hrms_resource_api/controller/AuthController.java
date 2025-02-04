package com.birby.hrms_resource_api.controller;

import com.birby.hrms_resource_api.dto.response.AuthResDto;
import com.birby.hrms_resource_api.mapper.AuthPrincipalMapper;
import com.birby.hrms_resource_api.service.auth.PrincipalService;
import com.birby.hrms_resource_api.service.control.AuthControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final AuthControlService authControlService;
    private final AuthPrincipalMapper authPrincipalMapper;
    @Autowired
    public AuthController(
            AuthControlService authControlService,
            AuthPrincipalMapper authPrincipalMapper
    ) {
        this.authControlService = authControlService;
        this.authPrincipalMapper = authPrincipalMapper;
    }
    @GetMapping()
    public AuthResDto getPrincipal(Principal principal){
        return authPrincipalMapper.toAuthResDto(authControlService.getAuthData(principal));
    }
}

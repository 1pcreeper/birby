package com.birby.hrms_resource_api.controller;

import com.birby.hrms_resource_api.dto.response.AuthResDto;
import com.birby.hrms_resource_api.exception.UnAuthorizedException;
import com.birby.hrms_resource_api.mapper.AuthPrincipalMapper;
import com.birby.hrms_resource_api.service.control.BloomFilterControlService;
import com.birby.hrms_resource_api.service.control.AuthControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final AuthControlService authControlService;
    private final AuthPrincipalMapper authPrincipalMapper;
    private final BloomFilterControlService bloomFilterControlService;
    @Autowired
    public AuthController(
            AuthControlService authControlService,
            AuthPrincipalMapper authPrincipalMapper,
            BloomFilterControlService bloomFilterControlService
    ) {
        this.authControlService = authControlService;
        this.authPrincipalMapper = authPrincipalMapper;
        this.bloomFilterControlService = bloomFilterControlService;
    }
    @GetMapping()
    public AuthResDto getPrincipal(
            @RequestHeader(name = "Authorization")String authorization ,
            Principal principal
    ) throws UnAuthorizedException {
        AuthResDto authData = authPrincipalMapper.toAuthResDto(authControlService.getAuthData(principal,authorization));
        bloomFilterControlService.authorize(authData.getStaffId(),authData.getRoleIds());
        return authData;
    }
}

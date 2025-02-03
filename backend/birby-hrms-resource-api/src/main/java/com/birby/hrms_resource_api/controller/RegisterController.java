package com.birby.hrms_resource_api.controller;

import com.birby.hrms_resource_api.dto.ApiResponse;
import com.birby.hrms_resource_api.dto.request.RegisterReqDto;
import com.birby.hrms_resource_api.dto.response.RegisterResDto;
import com.birby.hrms_resource_api.mapper.RegisterMapper;
import com.birby.hrms_resource_api.service.control.RegisterControlService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/register")
public class RegisterController {
    private final RegisterControlService registerControlService;
    private final RegisterMapper registerMapper;

    public RegisterController(
            RegisterControlService registerControlService,
            RegisterMapper registerMapper
    ) {
        this.registerControlService = registerControlService;
        this.registerMapper = registerMapper;
    }

    @PermitAll
    @PostMapping
    public ApiResponse<RegisterResDto> register(@Valid @RequestBody RegisterReqDto reqDto) {
        return ApiResponse.ok(
                true,
                "Registered new account",
                registerMapper.toRegisterResDto(registerControlService.register(
                        reqDto.getName(),
                        reqDto.getEmail(),
                        reqDto.getPassword()
                ))
        );
    }
}

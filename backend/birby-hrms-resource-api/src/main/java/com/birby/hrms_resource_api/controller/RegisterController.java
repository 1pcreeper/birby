package com.birby.hrms_resource_api.controller;

import com.birby.hrms_resource_api.dto.ApiResponse;
import com.birby.hrms_resource_api.dto.request.RegisterReqDto;
import com.birby.hrms_resource_api.dto.response.RegisterResDto;
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
    public RegisterController(
            RegisterControlService registerControlService
    ){
        this.registerControlService = registerControlService;
    }
    @PermitAll
    @PostMapping
    public ApiResponse<RegisterResDto> register(@Valid @RequestBody RegisterReqDto reqDto){
        return ApiResponse.ok(
                true,
                "Registered new account",
                RegisterResDto
                        .builder()
                        .uid(registerControlService.register(
                                reqDto.getName(),
                                reqDto.getEmail(),
                                reqDto.getPassword()
                        ))
                        .build()
        );
    }
}

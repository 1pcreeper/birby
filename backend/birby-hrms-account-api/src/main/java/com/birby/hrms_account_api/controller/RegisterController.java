package com.birby.hrms_account_api.controller;

import com.birby.hrms_account_api.model.dto.ApiResponse;
import com.birby.hrms_account_api.model.dto.request.RegisterReqDto;
import com.birby.hrms_account_api.model.dto.response.StaffResDto;
import com.birby.hrms_account_api.service.manager.RegisterManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/register")
public class RegisterController {
    private final RegisterManagerService registerManagerService;
    @Autowired
    public RegisterController(
            RegisterManagerService registerManagerService
    ) {
        this.registerManagerService = registerManagerService;
    }

    @PostMapping()
    public ApiResponse<StaffResDto> register(@Valid @RequestBody RegisterReqDto reqDto) {
        return ApiResponse.ok(
                "Registered new account",
                registerManagerService.register(
                        reqDto.getName(),
                        reqDto.getPassword(),
                        reqDto.getDisplayName()
                )
        );
    }
}

package com.birby.hrms_account_api.app.controller.general;

import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.dto.req.RegisterV1ReqDTO;
import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.service.common.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final RegisterService registerService;
    @Autowired
    public RegisterController(
            RegisterService registerService
    ) {
        this.registerService = registerService;
    }

    @PostMapping("/v1/register")
    public ApiResponse<StaffV1ResDTO> registerV1(@Valid @RequestBody RegisterV1ReqDTO reqDto) {
        return ApiResponse.ok(
                "Registered new account",
                "1.0.0",
                registerService.registerV1(
                        reqDto.getName(),
                        reqDto.getPassword(),
                        reqDto.getDisplayName()
                )
        );
    }
}

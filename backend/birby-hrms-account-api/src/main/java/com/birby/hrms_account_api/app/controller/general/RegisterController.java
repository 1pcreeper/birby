package com.birby.hrms_account_api.app.controller.general;

import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.dto.req.RegisterV1ReqDTO;
import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.service.manager.RegisterManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final RegisterManagerService registerManagerService;
    @Autowired
    public RegisterController(
            RegisterManagerService registerManagerService
    ) {
        this.registerManagerService = registerManagerService;
    }

    @PostMapping("/v1/register")
    public ApiResponse<StaffV1ResDTO> registerV1(@Valid @RequestBody RegisterV1ReqDTO reqDto) {
        return ApiResponse.ok(
                "Registered new account",
                registerManagerService.registerV1(
                        reqDto.getName(),
                        reqDto.getPassword(),
                        reqDto.getDisplayName()
                )
        );
    }
}

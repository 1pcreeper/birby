package com.birby.hrms.controller;

import com.birby.hrms.constant.Roles;
import com.birby.hrms.dto.ApiResponse;
import com.birby.hrms.dto.request.StaffCreateReqDto;
import com.birby.hrms.dto.response.StaffCreateResDto;
import com.birby.hrms.vo.JwtPrincipal;
import jakarta.validation.Valid;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/staff")
public class StaffController {
    @Secured({Roles.HR_ADMIN,Roles.IT_ROOT})
    @PostMapping("/create")
    public ApiResponse<StaffCreateResDto> create(
            @Valid @RequestBody StaffCreateReqDto reqDto,
            @AuthenticationPrincipal JwtPrincipal jwtPrincipal
    ){
        return null;
    }
}

package com.birby.hrms_account_api.controller;

import com.birby.hrms_account_api.model.response.ApiResponse;
import com.birby.hrms_account_api.model.dto.req.StaffUpdateReqDto;
import com.birby.hrms_account_api.model.dto.res.StaffResDto;
import com.birby.hrms_account_api.service.manager.StaffManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/staff")
public class StaffController {
    private final StaffManagerService staffManagerService;

    @Autowired
    public StaffController(
            StaffManagerService staffManagerService
    ) {
        this.staffManagerService = staffManagerService;
    }

    @PutMapping("/{id}")
    public ApiResponse<StaffResDto> updateStaff(@PathVariable(name = "id")String staffId,@Valid @RequestBody StaffUpdateReqDto reqDto) {
        return ApiResponse.ok("Updated Staff",
                staffManagerService.updateStaff(staffId,reqDto)
        );
    }

    @GetMapping(path = "/{id}")
    public ApiResponse<StaffResDto> getStaff(@PathVariable(name = "id")String staffId){
        return ApiResponse.ok(
                "Get Staff Info",
                staffManagerService.getStaff(staffId)
        );
    }
    @GetMapping(path = "/me")
    public ApiResponse<StaffResDto> getStaffMyself(Principal principal){
        return ApiResponse.ok(
                "Your Staff Info",
                staffManagerService.getStaffMyself(principal)
        );
    }
}

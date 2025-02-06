package com.birby.hrms_resource_api.controller;

import com.birby.hrms_resource_api.dto.ApiResponse;
import com.birby.hrms_resource_api.dto.request.StaffRoleReqDto;
import com.birby.hrms_resource_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_resource_api.service.control.StaffRoleControlService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/staff-role")
public class StaffRoleController {
    private final StaffRoleControlService staffRoleControlService;
    @Autowired
    public StaffRoleController(
            StaffRoleControlService staffRoleControlService
    ){
        this.staffRoleControlService = staffRoleControlService;
    }
    @PostMapping()
    public ApiResponse<String> updateStaffRoles(@Valid @RequestBody StaffRoleReqDto reqDto)
            throws DatabaseUpdateFailureException , FirebaseAuthException
    {
        staffRoleControlService.setStaffRoles(reqDto.getStaffId(),reqDto.getRoleIds());
        return ApiResponse.ok(
          "Updated StaffRoles",
          ""
        );
    }
}

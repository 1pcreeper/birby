package com.birby.hrms_resource_api.controller;

import com.birby.hrms_resource_api.dto.ApiResponse;
import com.birby.hrms_resource_api.dto.request.StaffRoleReqDto;
import com.birby.hrms_resource_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_resource_api.service.manager.StaffRoleManagerService;
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
    private final StaffRoleManagerService staffRoleManagerService;
    @Autowired
    public StaffRoleController(
            StaffRoleManagerService staffRoleManagerService
    ){
        this.staffRoleManagerService = staffRoleManagerService;
    }
    @PostMapping()
    public ApiResponse<String> updateStaffRoles(@Valid @RequestBody StaffRoleReqDto reqDto)
            throws DatabaseUpdateFailureException , FirebaseAuthException
    {
        staffRoleManagerService.setStaffRoles(reqDto.getStaffId(),reqDto.getRoleIds());
        return ApiResponse.ok(
          "Updated StaffRoles",
          ""
        );
    }
}

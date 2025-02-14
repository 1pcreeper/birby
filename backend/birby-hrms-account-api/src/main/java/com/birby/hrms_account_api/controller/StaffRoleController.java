package com.birby.hrms_account_api.controller;

import com.birby.hrms_account_api.dto.ApiResponse;
import com.birby.hrms_account_api.dto.request.StaffRoleUpdateReqDto;
import com.birby.hrms_account_api.dto.response.StaffRoleIdsResDto;
import com.birby.hrms_account_api.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.service.manager.BloomFilterManagerService;
import com.birby.hrms_account_api.service.manager.StaffRoleManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.security.Principal;

@RestController
@RequestMapping(path = "/staff-role")
public class StaffRoleController {
    private final StaffRoleManagerService staffRoleManagerService;
    private final BloomFilterManagerService bloomFilterManagerService;
    @Autowired
    public StaffRoleController(
            StaffRoleManagerService staffRoleManagerService,
            BloomFilterManagerService bloomFilterManagerService
    ){
        this.staffRoleManagerService = staffRoleManagerService;
        this.bloomFilterManagerService = bloomFilterManagerService;
    }
    @PutMapping("/{id}")
    public ApiResponse<String> updateStaffRoles(@PathVariable(name = "id")String staffId,@Valid @RequestBody StaffRoleUpdateReqDto reqDto)
            throws DatabaseUpdateFailureException , FirebaseAuthException
    {
        staffRoleManagerService.setStaffRoles(staffId,reqDto.getRoleIds());
        bloomFilterManagerService.addBloom(staffId,reqDto.getRoleIds());
        return ApiResponse.ok(
          "Updated StaffRoles",
          ""
        );
    }
    @GetMapping("/view-uid/{uid}")
    public ApiResponse<StaffRoleIdsResDto> getStaffRolesByUid(@PathVariable(name = "uid")String uid){
        return ApiResponse.ok(
                "Get Staff's Roles By Uid",
                staffRoleManagerService.getStaffRolesByUid(uid)
        );
    }
    @GetMapping("/view-uid/me")
    public ApiResponse<StaffRoleIdsResDto> getStaffRolesByUidMyself(Principal principal){
        return ApiResponse.ok(
                "Get Staff's Roles of Myself",
                staffRoleManagerService.getStaffRolesByUid(principal.getName())
        );
    }
}

package com.birby.hrms_account_api.controller.general;

import com.birby.hrms_account_api.model.response.ApiResponse;
import com.birby.hrms_account_api.model.dto.req.StaffRoleUpdateReqDto;
import com.birby.hrms_account_api.model.dto.res.StaffRoleIdsResDto;
import com.birby.hrms_account_api.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.service.manager.StaffRoleManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    @PutMapping("/{id}")
    public ApiResponse<String> updateStaffRoles(@PathVariable(name = "id")String staffId,@Valid @RequestBody StaffRoleUpdateReqDto reqDto)
            throws DatabaseUpdateFailureException , FirebaseAuthException
    {
        staffRoleManagerService.setStaffRoles(staffId,reqDto.getRoleIds());
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

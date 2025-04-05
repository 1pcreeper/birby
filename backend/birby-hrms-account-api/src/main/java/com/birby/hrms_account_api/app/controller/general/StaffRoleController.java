package com.birby.hrms_account_api.app.controller.general;

import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.dto.req.StaffRoleUpdateV1ReqDTO;
import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsV1ResDTO;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.service.manager.StaffRoleManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class StaffRoleController {
    private final StaffRoleManagerService staffRoleManagerService;
    @Autowired
    public StaffRoleController(
            StaffRoleManagerService staffRoleManagerService
    ){
        this.staffRoleManagerService = staffRoleManagerService;
    }
    @PutMapping("/v1/staff-role/{id}")
    public ApiResponse<String> updateStaffRolesV1(
            @PathVariable(name = "id")String staffId,
            @Valid @RequestBody StaffRoleUpdateV1ReqDTO reqDto,
            @RequestHeader(name = "Authorization")String authorization
    )
            throws DatabaseUpdateFailureException , FirebaseAuthException
    {
        staffRoleManagerService.setStaffRolesV1(staffId,reqDto.getRoleIds(),authorization);
        return ApiResponse.ok(
          "Updated StaffRoles",
          ""
        );
    }
    @GetMapping("/v1/staff-role/view-uid/{uid}")
    public ApiResponse<StaffRoleIdsV1ResDTO> getStaffRolesByUidV1(@PathVariable(name = "uid")String uid){
        return ApiResponse.ok(
                "Get Staff's Roles By Uid",
                staffRoleManagerService.getStaffRolesByUidV1(uid)
        );
    }
    @GetMapping("/v1/staff-role/view-uid/me")
    public ApiResponse<StaffRoleIdsV1ResDTO> getStaffRolesByUidMyselfV1(Principal principal){
        return ApiResponse.ok(
                "Get Staff's Roles of Myself",
                staffRoleManagerService.getStaffRolesByUidV1(principal.getName())
        );
    }
}

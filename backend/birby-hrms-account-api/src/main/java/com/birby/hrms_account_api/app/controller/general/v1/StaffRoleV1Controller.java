package com.birby.hrms_account_api.app.controller.general.v1;

import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.dto.req.StaffRoleUpdateV1ReqDTO;
import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsV1ResDTO;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.service.common.StaffRoleService;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/v1/staff-role")
public class StaffRoleV1Controller {
    private final StaffRoleService staffRoleService;
    @Autowired
    public StaffRoleV1Controller(
            StaffRoleService staffRoleService
    ){
        this.staffRoleService = staffRoleService;
    }
    @PutMapping("/{id}")
    public ApiResponse<String> updateStaffRolesV1(
            @PathVariable(name = "id")String staffId,
            @Valid @RequestBody StaffRoleUpdateV1ReqDTO reqDto,
            @RequestHeader(name = "Authorization")String authorization
    )
            throws DatabaseUpdateFailureException , FirebaseAuthException
    {
        staffRoleService.setStaffRolesV1(staffId,reqDto.getRoleIds(),authorization);
        return ApiResponse.ok(
          "Updated StaffRoles",
                "1.0.0",
                ""
        );
    }
    @GetMapping("/view-uid/{uid}")
    public ApiResponse<StaffRoleIdsV1ResDTO> getStaffRolesByUidV1(@PathVariable(name = "uid")String uid){
        return ApiResponse.ok(
                "Get Staff's Roles By Uid",
                "1.0.0",
                staffRoleService.getStaffRolesByUidV1(uid)
        );
    }
    @GetMapping("/view-uid/me")
    public ApiResponse<StaffRoleIdsV1ResDTO> getStaffRolesByUidMyselfV1(Principal principal){
        return ApiResponse.ok(
                "Get Staff's Roles of Myself",
                "1.0.0",
                staffRoleService.getStaffRolesByUidV1(principal.getName())
        );
    }
}

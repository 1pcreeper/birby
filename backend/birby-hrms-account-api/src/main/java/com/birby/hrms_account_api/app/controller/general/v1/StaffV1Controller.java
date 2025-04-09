package com.birby.hrms_account_api.app.controller.general.v1;

import com.birby.hrms_account_api.app.model.dto.req.StaffUpdateV1ReqDTO;
import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.service.common.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/v1/staff")
public class StaffV1Controller {
    private final StaffService staffService;

    @Autowired
    public StaffV1Controller(
            StaffService staffService
    ) {
        this.staffService = staffService;
    }

    @PutMapping("/{id}")
    public ApiResponse<StaffV1ResDTO> updateStaffV1(@PathVariable(name = "id")String staffId, @Valid @RequestBody StaffUpdateV1ReqDTO reqDto) {
        return ApiResponse.ok("Updated Staff",
                "1.0.0",
                staffService.updateStaffV1(staffId,reqDto)
        );
    }

    @GetMapping(path = "/{id}")
    public ApiResponse<StaffV1ResDTO> getStaffV1(@PathVariable(name = "id")String staffId){
        return ApiResponse.ok(
                "Get Staff Info",
                "1.0.0",
                staffService.getStaffV1(staffId)
        );
    }
    @GetMapping(path = "/me")
    public ApiResponse<StaffV1ResDTO> getStaffMyselfV1(Principal principal){
        return ApiResponse.ok(
                "Your Staff Info",
                "1.0.0",
                staffService.getStaffMyselfV1(principal)
        );
    }
}

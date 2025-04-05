package com.birby.hrms_account_api.app.controller.general;

import com.birby.hrms_account_api.app.model.dto.req.StaffUpdateV1ReqDTO;
import com.birby.hrms_account_api.app.model.response.ApiResponse;
import com.birby.hrms_account_api.app.model.dto.res.StaffV1ResDTO;
import com.birby.hrms_account_api.app.service.manager.StaffManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class StaffController {
    private final StaffManagerService staffManagerService;

    @Autowired
    public StaffController(
            StaffManagerService staffManagerService
    ) {
        this.staffManagerService = staffManagerService;
    }

    @PutMapping("/v1/staff/{id}")
    public ApiResponse<StaffV1ResDTO> updateStaffV1(@PathVariable(name = "id")String staffId, @Valid @RequestBody StaffUpdateV1ReqDTO reqDto) {
        return ApiResponse.ok("Updated Staff",
                staffManagerService.updateStaffV1(staffId,reqDto)
        );
    }

    @GetMapping(path = "/v1/staff/{id}")
    public ApiResponse<StaffV1ResDTO> getStaffV1(@PathVariable(name = "id")String staffId){
        return ApiResponse.ok(
                "Get Staff Info",
                staffManagerService.getStaffV1(staffId)
        );
    }
    @GetMapping(path = "/v1/staff/me")
    public ApiResponse<StaffV1ResDTO> getStaffMyselfV1(Principal principal){
        return ApiResponse.ok(
                "Your Staff Info",
                staffManagerService.getStaffMyselfV1(principal)
        );
    }
}

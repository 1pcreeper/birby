package com.birby.hrms_resource_api.controller;

import com.birby.hrms_resource_api.dto.ApiResponse;
import com.birby.hrms_resource_api.dto.request.StaffUpdateReqDto;
import com.birby.hrms_resource_api.dto.response.StaffUpdateResDto;
import com.birby.hrms_resource_api.mapper.StaffMapper;
import com.birby.hrms_resource_api.service.manager.StaffManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/staff")
public class StaffController {
    private final StaffManagerService staffManagerService;
    private final StaffMapper staffMapper;

    @Autowired
    public StaffController(
            StaffManagerService staffManagerService,
            StaffMapper staffMapper
    ) {
        this.staffManagerService = staffManagerService;
        this.staffMapper = staffMapper;
    }

    @PutMapping()
    public ApiResponse<StaffUpdateResDto> updateStaff(@Valid @RequestBody StaffUpdateReqDto reqDto) {
        return ApiResponse.ok("Updated Staff",
                staffMapper.toStaffUpdateResDto(
                        staffManagerService.updateStaff(staffMapper.toStaffUpdateReqBo(reqDto))
                )
        );
    }
}

package com.birby.hrms.service.control.impl;

import com.birby.hrms.bo.request.StaffCreateReqBo;
import com.birby.hrms.bo.response.ResourceRegisterResCliBo;
import com.birby.hrms.bo.response.StaffCreateResBo;
import com.birby.hrms.dto.ApiResponse;
import com.birby.hrms.exception.DatabaseUpdateFailureException;
import com.birby.hrms.exception.ResourceUpdateFailureException;
import com.birby.hrms.model.Staff;
import com.birby.hrms.model.StaffDetail;
import com.birby.hrms.service.cli.ResourceRegisterCliService;
import com.birby.hrms.service.control.StaffControlService;
import com.birby.hrms.service.entity.StaffDetailEntityService;
import com.birby.hrms.service.entity.StaffEntityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffControlServiceImpl implements StaffControlService {
    private final ResourceRegisterCliService resourceRegisterCliService;
    private final StaffEntityService staffEntityService;
    private final StaffDetailEntityService staffDetailEntityService;

    @Autowired
    public StaffControlServiceImpl(
            ResourceRegisterCliService resourceRegisterCliService,
            StaffEntityService staffEntityService,
            StaffDetailEntityService staffDetailEntityService
    ) {
        this.resourceRegisterCliService = resourceRegisterCliService;
        this.staffEntityService = staffEntityService;
        this.staffDetailEntityService = staffDetailEntityService;
    }

    @Override
    @Transactional
    public StaffCreateResBo createStaffAndStaffDetail(StaffCreateReqBo reqBo)
            throws DatabaseUpdateFailureException, ResourceUpdateFailureException {
        ApiResponse<ResourceRegisterResCliBo> resCliBo = resourceRegisterCliService.register(
                reqBo.getResourceRegisterReqCliBo(), reqBo.getToken()
        );
        if (!resCliBo.isSuccess()) {
            throw new ResourceUpdateFailureException(resCliBo.getMessage());
        }
        String newStaffId = resCliBo.getData().getStaffId();
        StaffDetail staffDetail = reqBo.getStaffDetail();
        Staff staff = Staff.builder()
                .id(newStaffId)
                .displayName(reqBo.getResourceRegisterReqCliBo().getDisplayName())
                .build();
        Staff newStaff = staffEntityService.save(staff);
        staffDetail.setId(newStaffId);
        staffDetail.setStaff(newStaff);
        StaffDetail newStaffDetail = staffDetailEntityService.save(staffDetail);
        return StaffCreateResBo.builder()
                .staffDetail(newStaffDetail)
                .email(resCliBo.getData().getEmail())
                .build();
    }
}

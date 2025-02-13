package com.birby.hrms.service.control.impl;

import com.birby.hrms.bo.request.StaffReqBo;
import com.birby.hrms.bo.response.ResourceRegisterResCliBo;
import com.birby.hrms.dto.ApiResponse;
import com.birby.hrms.exception.DatabaseUpdateFailureException;
import com.birby.hrms.exception.ResourceUpdateFailureException;
import com.birby.hrms.model.Staff;
import com.birby.hrms.model.StaffDetail;
import com.birby.hrms.service.cli.ResourceRegisterCliService;
import com.birby.hrms.service.control.StaffControlService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffControlServiceImpl implements StaffControlService {
    private final ResourceRegisterCliService resourceRegisterCliService;
    @Autowired
    public StaffControlServiceImpl(
            ResourceRegisterCliService resourceRegisterCliService
    ){
        this.resourceRegisterCliService = resourceRegisterCliService;
    }
    @Override
    @Transactional
    public StaffDetail createStaffAndStaffDetail(StaffReqBo reqBo)
            throws DatabaseUpdateFailureException, ResourceUpdateFailureException{
        ApiResponse<ResourceRegisterResCliBo> resCliBo = resourceRegisterCliService.register(
                reqBo.getResourceRegisterReqCliBo(),reqBo.getToken()
        );
        if(!resCliBo.isSuccess()){
            throw new ResourceUpdateFailureException(resCliBo.getMessage());
        }
        String newStaffId = resCliBo.getData().getStaffId();
        StaffDetail staffDetail = reqBo.getStaffDetail();
        Staff staff = Staff.builder()
                .id(newStaffId)
                .displayName(reqBo.getResourceRegisterReqCliBo().getDisplayName())
                .build();
        return null;
    }
}

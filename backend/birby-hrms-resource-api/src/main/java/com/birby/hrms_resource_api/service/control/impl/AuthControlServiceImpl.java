package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.bo.response.AuthResBo;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.exception.UnAuthorizedException;
import com.birby.hrms_resource_api.model.Staff;
import com.birby.hrms_resource_api.service.auth.PrincipalService;
import com.birby.hrms_resource_api.service.control.AuthControlService;
import com.birby.hrms_resource_api.service.entity.StaffEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
public class AuthControlServiceImpl implements AuthControlService {
    private final PrincipalService principalService;
    private final StaffEntityService staffEntityService;
    @Autowired
    public AuthControlServiceImpl(
            PrincipalService principalService,
            StaffEntityService staffEntityService
    ){
        this.principalService = principalService;
        this.staffEntityService = staffEntityService;
    }
    @Override
    public AuthResBo getAuthData(Principal principal) throws UnAuthorizedException,ResourceNotFoundException {
        Map<String,Object> principalData = principalService.getPrincipalData(principal);
        String uid = (String) principalData.get("uid");
        Staff staff = staffEntityService.findByUid(uid);
        return AuthResBo
                .builder()
                .principalData(principalData)
                .staffId(staff.getId())
                .build();
    }
}

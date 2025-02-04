package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.bo.response.AuthResBo;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Staff;
import com.birby.hrms_resource_api.properties.FirebaseProperties;
import com.birby.hrms_resource_api.service.auth.PrincipalService;
import com.birby.hrms_resource_api.service.control.AuthControlService;
import com.birby.hrms_resource_api.service.manager.StaffManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Service
public class AuthControlServiceImpl implements AuthControlService {
    private final PrincipalService principalService;
    private final StaffManagerService staffManagerService;
    @Autowired
    public AuthControlServiceImpl(
            PrincipalService principalService,
            StaffManagerService staffManagerService
    ){
        this.principalService = principalService;
        this.staffManagerService = staffManagerService;
    }
    @Override
    public AuthResBo getAuthData(Principal principal) throws ResourceNotFoundException {
        Map<String,Object> principalData = principalService.getPrincipalData(principal);
        String uid = (String) principalData.get("uid");
        Staff staff = staffManagerService.findByUid(uid);
        return AuthResBo
                .builder()
                .principalData(principalData)
                .staffId(staff.getId())
                .build();
    }
}

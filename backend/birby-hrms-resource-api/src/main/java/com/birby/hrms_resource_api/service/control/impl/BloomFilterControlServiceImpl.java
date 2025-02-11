package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.exception.UnAuthorizedException;
import com.birby.hrms_resource_api.model.StaffRole;
import com.birby.hrms_resource_api.service.control.BloomFilterControlService;
import com.birby.hrms_resource_api.service.manager.BloomFilterManagerService;
import com.birby.hrms_resource_api.service.manager.StaffRoleManagerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BloomFilterControlServiceImpl implements BloomFilterControlService {
    private final BloomFilterManagerService bloomFilterManagerService;
    private final StaffRoleManagerService staffRoleManagerService;

    public BloomFilterControlServiceImpl(
            BloomFilterManagerService bloomFilterManagerService,
            StaffRoleManagerService staffRoleManagerService
    ) {
        this.bloomFilterManagerService = bloomFilterManagerService;
        this.staffRoleManagerService = staffRoleManagerService;
    }

    @Override
    public void addBloom(String staffId, List<String> roleIds) {
        Collections.sort(roleIds);
        String data = staffId.concat(roleIds.toString());
        bloomFilterManagerService.add(data);
    }

    @Override
    public void authorize(String staffId, List<String> roleIds) throws UnAuthorizedException {
        Collections.sort(roleIds);
        String data = staffId.concat(roleIds.toString());
        if(!bloomFilterManagerService.mightContain(data)){
            return;
        }
        List<StaffRole> staffRoles = staffRoleManagerService.findByStaffId(staffId);
        List<String> dbRoleIds = new ArrayList<>();
        for(StaffRole sr : staffRoles){
            dbRoleIds.add(sr.getRole().getId());
        }
        Collections.sort(dbRoleIds);
        if(!roleIds.equals(dbRoleIds)){
            throw new UnAuthorizedException("Token Expired");
        }
    }
}

package com.birby.hrms_account_api.app.service.common.impl;

import com.birby.hrms_account_api.app.model.exception.UnAuthorizedException;
import com.birby.hrms_account_api.app.model.entity.Staff;
import com.birby.hrms_account_api.app.model.entity.StaffRole;
import com.birby.hrms_account_api.app.service.data.BloomDataService;
import com.birby.hrms_account_api.app.service.entity.StaffEntityService;
import com.birby.hrms_account_api.app.service.entity.StaffRoleEntityService;
import com.birby.hrms_account_api.app.service.common.BloomFilterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BloomFilterServiceImpl implements BloomFilterService {
    private final StaffRoleEntityService staffRoleEntityService;
    private final StaffEntityService staffEntityService;
    private final BloomDataService bloomDataService;
    public BloomFilterServiceImpl(
            StaffRoleEntityService staffRoleEntityService,
            StaffEntityService staffEntityService,
            BloomDataService bloomDataService
    ) {
        this.staffRoleEntityService = staffRoleEntityService;
        this.staffEntityService = staffEntityService;
        this.bloomDataService = bloomDataService;
    }

    @Override
    public void addBloom(String uid, List<String> roleIds) {
        bloomDataService.put(uid, roleIds);
    }

    @Override
    public void authorize(String uid, List<String> roleIds) throws UnAuthorizedException {
        if(!bloomDataService.mightContain(uid,roleIds)){
            return;
        }
        Staff staff = staffEntityService.findByUid(uid);
        List<StaffRole> dbStaffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        List<String> dbRoleIds = dbStaffRoles.stream().map(sr->sr.getRole().getId()).collect(Collectors.toUnmodifiableList());
        if(!roleIds.equals(dbRoleIds)){
            throw new UnAuthorizedException("Token Expired");
        }
    }
}
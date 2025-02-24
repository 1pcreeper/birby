package com.birby.hrms_account_api.service.common.impl;

import com.birby.hrms_account_api.cache.BloomCache;
import com.birby.hrms_account_api.exception.UnAuthorizedException;
import com.birby.hrms_account_api.model.entity.Staff;
import com.birby.hrms_account_api.model.entity.StaffRole;
import com.birby.hrms_account_api.service.entity.StaffEntityService;
import com.birby.hrms_account_api.service.entity.StaffRoleEntityService;
import com.birby.hrms_account_api.service.common.BloomFilterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloomFilterServiceImpl implements BloomFilterService {
    private final StaffRoleEntityService staffRoleEntityService;
    private final StaffEntityService staffEntityService;
    public BloomFilterServiceImpl(
            StaffRoleEntityService staffRoleEntityService,
            StaffEntityService staffEntityService
    ) {
        this.staffRoleEntityService = staffRoleEntityService;
        this.staffEntityService = staffEntityService;
    }

    @Override
    public void addBloom(String uid, List<String> roleIds) {
        BloomCache.put(uid,roleIds);
    }

    @Override
    public void authorize(String uid, List<String> roleIds) throws UnAuthorizedException {
        if(!BloomCache.mightContain(uid,roleIds)){
            return;
        }
        Staff staff = staffEntityService.findByUid(uid);
        List<StaffRole> dbStaffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        List<String> dbRoleIds = new ArrayList<>();
        dbStaffRoles.forEach(sr->dbRoleIds.add(sr.getId().getRoleId()));
        if(!roleIds.equals(dbRoleIds)){
            throw new UnAuthorizedException("Token Expired");
        }
    }
}
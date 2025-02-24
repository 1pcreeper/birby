package com.birby.hrms_account_api.service.manager.impl;

import com.birby.hrms_account_api.model.bo.request.FirebaseAuthCreateUserReqBo;
import com.birby.hrms_account_api.constant.Roles;
import com.birby.hrms_account_api.model.dto.response.StaffResDto;
import com.birby.hrms_account_api.exception.RegisterFailureException;
import com.birby.hrms_account_api.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.mapper.StaffMapper;
import com.birby.hrms_account_api.model.entity.Staff;
import com.birby.hrms_account_api.properties.FirebaseProperties;
import com.birby.hrms_account_api.service.auth.FirebaseAuthService;
import com.birby.hrms_account_api.service.manager.RegisterManagerService;
import com.birby.hrms_account_api.service.entity.StaffEntityService;
import com.birby.hrms_account_api.service.entity.StaffRoleEntityService;
import com.birby.hrms_account_api.util.UuidUtil;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@EnableConfigurationProperties(FirebaseProperties.class)
public class RegisterManagerServiceImpl implements RegisterManagerService {
    private final FirebaseAuthService firebaseAuthService;
    private final StaffEntityService staffEntityService;
    private final StaffRoleEntityService staffRoleEntityService;
    private final FirebaseProperties firebaseProperties;
    private final StaffMapper staffMapper;
    @Autowired
    public RegisterManagerServiceImpl(
            FirebaseAuthService firebaseAuthService,
            StaffEntityService staffEntityService,
            StaffRoleEntityService staffRoleEntityService,
            FirebaseProperties firebaseProperties,
            StaffMapper staffMapper
    ) {
        this.firebaseAuthService = firebaseAuthService;
        this.staffEntityService = staffEntityService;
        this.staffRoleEntityService = staffRoleEntityService;
        this.firebaseProperties = firebaseProperties;
        this.staffMapper = staffMapper;
    }

    @Override
    @Transactional(rollbackOn = RuntimeException.class)
    public StaffResDto register(String name, String password, String displayName) throws RegisterFailureException {
        List<String> roles = List.of(Roles.DEFAULT_STAFF);

        String alignedName = name.toLowerCase(Locale.ROOT).trim();
        String alignedEmail = alignedName.concat("@").concat(firebaseProperties.getDefaultRegisterEmail());

        boolean isEmailExisted = true;
        boolean isNameExisted = true;
        boolean isEmailExistedInFirebase = true;
        String errMessage = "";
        try {
            firebaseAuthService.getUserByEmail(alignedEmail);
            errMessage = "Email Already Existed";
        } catch (FirebaseAuthException e) {
            isEmailExistedInFirebase = false;
        }
        try {
            staffEntityService.findByName(alignedName);
            errMessage = "Name Already Existed";
        } catch (ResourceNotFoundException e) {
            isNameExisted = false;
        }
        try {
            staffEntityService.findByEmail(alignedEmail);
            errMessage = "Email Already Existed";
        } catch (ResourceNotFoundException e) {
            isEmailExisted = false;
        }
        if (isEmailExisted || isNameExisted || isEmailExistedInFirebase) {
            throw new RegisterFailureException(errMessage);
        }
        FirebaseAuthCreateUserReqBo reqBo = FirebaseAuthCreateUserReqBo
                .builder()
                .displayName(displayName)
                .email(alignedEmail)
                .password(password)
                .disable(false)
                .build();
        String uid;
        String id = UuidUtil.generate();
        try {
            uid = firebaseAuthService.createUser(reqBo);
            firebaseAuthService.setRoleClaims(uid, roles);
        } catch (FirebaseAuthException e) {
            throw new RegisterFailureException(e.getMessage());
        }
        Staff newStaff = Staff
                .builder()
                .id(id)
                .uid(uid)
                .displayName(displayName)
                .name(alignedName)
                .email(alignedEmail)
                .build();
        staffEntityService.save(newStaff);
        for (String r : roles) {
            staffRoleEntityService.insert(id, r);
        }
        return staffMapper.toStaffResDto(newStaff);
    }
}

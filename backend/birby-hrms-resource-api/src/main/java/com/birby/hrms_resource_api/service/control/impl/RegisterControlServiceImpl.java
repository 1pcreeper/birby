package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.bo.request.FirebaseAuthCreateUserReqBo;
import com.birby.hrms_resource_api.bo.response.RegisterResBo;
import com.birby.hrms_resource_api.constant.Roles;
import com.birby.hrms_resource_api.exception.RegisterFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Staff;
import com.birby.hrms_resource_api.properties.FirebaseProperties;
import com.birby.hrms_resource_api.service.auth.FirebaseAuthService;
import com.birby.hrms_resource_api.service.control.RegisterControlService;
import com.birby.hrms_resource_api.service.entity.StaffEntityService;
import com.birby.hrms_resource_api.service.entity.StaffRoleEntityService;
import com.birby.hrms_resource_api.utility.UuidUtility;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@EnableConfigurationProperties(FirebaseProperties.class)
public class RegisterControlServiceImpl implements RegisterControlService {
    private final FirebaseAuthService firebaseAuthService;
    private final StaffEntityService staffEntityService;
    private final StaffRoleEntityService staffRoleEntityService;
    private final FirebaseProperties firebaseProperties;

    @Autowired
    public RegisterControlServiceImpl(
            FirebaseAuthService firebaseAuthService,
            StaffEntityService staffEntityService,
            StaffRoleEntityService staffRoleEntityService,
            FirebaseProperties firebaseProperties
    ) {
        this.firebaseAuthService = firebaseAuthService;
        this.staffEntityService = staffEntityService;
        this.staffRoleEntityService = staffRoleEntityService;
        this.firebaseProperties = firebaseProperties;
    }

    @Override
    @Transactional(rollbackOn = RuntimeException.class)
    public RegisterResBo register(String name,  String password, String displayName) throws RegisterFailureException {
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
        String id = UuidUtility.generate();
        try {
            uid = firebaseAuthService.createUser(reqBo);
            firebaseAuthService.setRoleClaims(uid, roles);
        } catch (FirebaseAuthException e) {
            throw new RegisterFailureException(e.getMessage());
        }
        Staff staff = Staff
                .builder()
                .id(id)
                .uid(uid)
                .displayName(displayName)
                .name(alignedName)
                .email(alignedEmail)
                .build();
        staffEntityService.save(staff);
        for (String r : roles) {
            staffRoleEntityService.insert(id, r);
        }
        return RegisterResBo.builder().staffId(id).uid(uid).build();
    }
}

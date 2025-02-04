package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.bo.request.FirebaseAuthCreateUserReqBo;
import com.birby.hrms_resource_api.bo.response.RegisterResBo;
import com.birby.hrms_resource_api.constant.Roles;
import com.birby.hrms_resource_api.exception.RegisterFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.model.Staff;
import com.birby.hrms_resource_api.service.auth.FirebaseAuthService;
import com.birby.hrms_resource_api.service.control.RegisterControlService;
import com.birby.hrms_resource_api.service.manager.StaffManagerService;
import com.birby.hrms_resource_api.service.manager.StaffRoleManagerService;
import com.birby.hrms_resource_api.utility.UuidUtility;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class RegisterControlServiceImpl implements RegisterControlService {
    private final FirebaseAuthService firebaseAuthService;
    private final StaffManagerService staffManagerService;
    private final StaffRoleManagerService staffRoleManagerService;
    @Autowired
    public RegisterControlServiceImpl(
            FirebaseAuthService firebaseAuthService,
            StaffManagerService staffManagerService,
            StaffRoleManagerService staffRoleManagerService
    ) {
        this.firebaseAuthService = firebaseAuthService;
        this.staffManagerService = staffManagerService;
        this.staffRoleManagerService = staffRoleManagerService;
    }

    @Override
    @Transactional(rollbackOn = RuntimeException.class)
    public RegisterResBo register(String name, String email, String password) throws RegisterFailureException {
        List<String> roles = List.of(Roles.DEFAULT_STAFF);

        String alignedName = name.toLowerCase(Locale.ROOT).trim();
        String alignedEmail = email.toLowerCase(Locale.ROOT).trim();

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
            staffManagerService.findByName(alignedName);
            errMessage = "Name Already Existed";
        } catch (ResourceNotFoundException e) {
            isNameExisted = false;
        }
        try {
            staffManagerService.findByEmail(alignedEmail);
            errMessage = "Email Already Existed";
        } catch (ResourceNotFoundException e) {
            isEmailExisted = false;
        }
        if (isEmailExisted || isNameExisted || isEmailExistedInFirebase) {
            throw new RegisterFailureException(errMessage);
        }
        FirebaseAuthCreateUserReqBo reqBo = FirebaseAuthCreateUserReqBo
                .builder()
                .displayName(alignedName)
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
        Staff newStaff = Staff
                .builder()
                .id(id)
                .uid(uid)
                .displayName(alignedName)
                .name(alignedName)
                .email(alignedEmail)
                .build();
        staffManagerService.save(newStaff);
        for(String r : roles){
            staffRoleManagerService.add(id,r);
        }
        return RegisterResBo.builder().staffId(id).uid(uid).build();
    }
}

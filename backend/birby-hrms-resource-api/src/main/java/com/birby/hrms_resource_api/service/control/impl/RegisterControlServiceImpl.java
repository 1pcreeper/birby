package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.bo.request.FirebaseAuthCreateUserReqBo;
import com.birby.hrms_resource_api.constant.Roles;
import com.birby.hrms_resource_api.exception.RegisterFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import com.birby.hrms_resource_api.service.auth.FirebaseAuthService;
import com.birby.hrms_resource_api.service.control.RegisterControlService;
import com.birby.hrms_resource_api.service.manager.StaffManagerService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class RegisterControlServiceImpl implements RegisterControlService {
    private final FirebaseAuthService firebaseAuthService;
    private final StaffManagerService staffManagerService;

    public RegisterControlServiceImpl(
            FirebaseAuthService firebaseAuthService,
            StaffManagerService staffManagerService
    ) {
        this.firebaseAuthService = firebaseAuthService;
        this.staffManagerService = staffManagerService;
    }

    @Override
    public String register(String name, String email, String password) throws RegisterFailureException {
        String alignedName = name.toLowerCase(Locale.ROOT).trim();
        String alignedEmail = email.toLowerCase(Locale.ROOT).trim();

        boolean isEmailExisted = true;
        boolean isNameExisted = true;
        boolean isEmailExistedInFirebase = true;
        String errMessage = "";
        try{
            firebaseAuthService.getUserByEmail(alignedEmail);
            errMessage="Email Already Existed";
        }catch (FirebaseAuthException e){
            isEmailExistedInFirebase=false;
        }
        try {
            staffManagerService.findByName(alignedName);
            errMessage="Name Already Existed";
        } catch (ResourceNotFoundException e) {
            isNameExisted=false;
        }
        try{
            staffManagerService.findByEmail(alignedEmail);
            errMessage="Email Already Existed";
        }catch(ResourceNotFoundException e){
            isEmailExisted=false;
        }
        if(isEmailExisted||isNameExisted||isEmailExistedInFirebase){
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
        try {
            uid = firebaseAuthService.createUser(reqBo);
            firebaseAuthService.setRoleClaims(uid, List.of(Roles.STAFF));
            return uid;
        } catch (FirebaseAuthException e) {
            throw new RegisterFailureException(e.getMessage());
        }
    }
}

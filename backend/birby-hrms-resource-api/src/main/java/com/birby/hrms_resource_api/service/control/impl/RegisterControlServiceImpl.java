package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.bo.request.FirebaseAuthCreateUserReqBo;
import com.birby.hrms_resource_api.exception.RegisterFailureException;
import com.birby.hrms_resource_api.service.auth.FirebaseAuthService;
import com.birby.hrms_resource_api.service.control.RegisterControlService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

@Service
public class RegisterControlServiceImpl implements RegisterControlService {
    private final FirebaseAuthService firebaseAuthService;
    public RegisterControlServiceImpl(
            FirebaseAuthService firebaseAuthService
    ){
        this.firebaseAuthService = firebaseAuthService;
    }
    @Override
    public String register(String name, String email, String password) throws RegisterFailureException {
        FirebaseAuthCreateUserReqBo reqBo = FirebaseAuthCreateUserReqBo
                .builder()
                .displayName(name)
                .email(email)
                .password(password)
                .disable(false)
                .build();
        String uid;
        try{
            uid = firebaseAuthService.createUser(reqBo);
            return uid;
        }catch (FirebaseAuthException e){
            throw new RegisterFailureException(e.getMessage());
        }
    }
}

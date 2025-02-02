package com.birby.resource_api.service.auth.impl;

import com.birby.resource_api.bo.request.FirebaseAuthCreateUserReqBo;
import com.birby.resource_api.properties.FirebaseProperties;
import com.birby.resource_api.service.auth.FirebaseAuthService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@EnableConfigurationProperties({FirebaseProperties.class,FirebaseProperties.class})
public class FirebaseAuthServiceImpl implements FirebaseAuthService {
    private final FirebaseAuth firebaseAuth;
    private final FirebaseProperties firebaseProperties;
    @Autowired
    public FirebaseAuthServiceImpl(
            FirebaseAuth firebaseAuth,
            FirebaseProperties firebaseProperties
    ){
        this.firebaseAuth = firebaseAuth;
        this.firebaseProperties = firebaseProperties;
    }

    @Override
    public String register(FirebaseAuthCreateUserReqBo reqBo) throws FirebaseAuthException {
        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest()
                .setDisplayName(reqBo.getDisplayName())
                .setEmail(reqBo.getEmail())
                .setPassword(reqBo.getPassword())
                .setDisabled(reqBo.isDisable())
                .setEmailVerified(reqBo.isEmailVerified())
                .setPhoneNumber(reqBo.getPhoneNumber())
                .setPhotoUrl(reqBo.getPhotoUrl());
        UserRecord userRecord = firebaseAuth.createUser(createRequest);
        return userRecord.getUid();
    }

    @Override
    public void setRoleClaims(String uid, List<String> roles) throws FirebaseAuthException {
        Map<String,Object> claims = Map.of(firebaseProperties.getRolesClaim(),roles);
        firebaseAuth.setCustomUserClaims(uid,claims);
    }
}

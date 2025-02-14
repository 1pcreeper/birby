package com.birby.hrms_account_api.service.auth.impl;

import com.birby.hrms_account_api.bo.request.FirebaseAuthCreateUserReqBo;
import com.birby.hrms_account_api.properties.FirebaseProperties;
import com.birby.hrms_account_api.service.auth.FirebaseAuthService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@EnableConfigurationProperties({FirebaseProperties.class})
public class FirebaseAuthServiceImpl implements FirebaseAuthService {
    private final FirebaseAuth firebaseAuth;
    private final FirebaseProperties firebaseProperties;

    @Autowired
    public FirebaseAuthServiceImpl(
            FirebaseAuth firebaseAuth,
            FirebaseProperties firebaseProperties
    ) {
        this.firebaseAuth = firebaseAuth;
        this.firebaseProperties = firebaseProperties;
    }

    @Override
    public String createUser(FirebaseAuthCreateUserReqBo reqBo) throws FirebaseAuthException {
        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest()
                .setDisplayName(reqBo.getDisplayName())
                .setEmail(reqBo.getEmail())
                .setPassword(reqBo.getPassword())
                .setDisabled(reqBo.isDisable());
//                .setEmailVerified(reqBo.isEmailVerified())
//                .setPhoneNumber(reqBo.getPhoneNumber());
//                .setPhotoUrl(reqBo.getPhotoUrl());
        UserRecord userRecord = firebaseAuth.createUser(createRequest);
        return userRecord.getUid();
    }

    @Override
    public void setRoleClaims(String uid, List<String> roles) throws FirebaseAuthException {
        Map<String, Object> claims = Map.of(firebaseProperties.getRolesClaim(), roles);
        firebaseAuth.revokeRefreshTokens(uid);
        firebaseAuth.setCustomUserClaims(uid, claims);
    }

    @Override
    public UserRecord getUser(String uid) throws FirebaseAuthException {
        return firebaseAuth.getUser(uid);
    }

    @Override
    public UserRecord getUserByEmail(String email) throws FirebaseAuthException {
        return firebaseAuth.getUserByEmail(email);
    }
}

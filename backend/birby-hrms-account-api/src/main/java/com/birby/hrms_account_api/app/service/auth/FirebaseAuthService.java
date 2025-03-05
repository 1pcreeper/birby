package com.birby.hrms_account_api.app.service.auth;

import com.birby.hrms_account_api.app.model.clidto.req.FirebaseAuthCreateUserReqCliDto;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import java.util.List;

public interface FirebaseAuthService {
    String createUser(FirebaseAuthCreateUserReqCliDto reqBo) throws FirebaseAuthException;
    void setRoleClaims(String uid, List<String> roles) throws FirebaseAuthException;
    UserRecord getUser(String uid) throws FirebaseAuthException;
    UserRecord getUserByEmail(String email) throws FirebaseAuthException;
}

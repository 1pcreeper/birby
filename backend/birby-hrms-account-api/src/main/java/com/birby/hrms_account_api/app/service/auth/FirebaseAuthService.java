package com.birby.hrms_account_api.app.service.auth;

import com.birby.hrms_account_api.app.model.cto.req.FirebaseAuthCreateUserV1ReqCTO;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import java.util.List;

public interface FirebaseAuthService {
    String createUser(FirebaseAuthCreateUserV1ReqCTO reqBo) throws FirebaseAuthException;

    void setClaims(String uid, List<String> roles , String staffId) throws FirebaseAuthException;

    UserRecord getUser(String uid) throws FirebaseAuthException;

    UserRecord getUserByEmail(String email) throws FirebaseAuthException;
}

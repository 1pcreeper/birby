package com.birby.resource_api.service.auth;

import com.birby.resource_api.bo.request.FirebaseAuthCreateUserReqBo;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.List;

public interface FirebaseAuthService {
    String register(FirebaseAuthCreateUserReqBo reqBo) throws FirebaseAuthException;
    void setRoleClaims(String uid, List<String> roles) throws FirebaseAuthException;
}

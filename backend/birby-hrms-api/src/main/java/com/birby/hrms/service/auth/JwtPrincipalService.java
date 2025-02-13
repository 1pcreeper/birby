package com.birby.hrms.service.auth;

import com.birby.hrms.exception.PrincipalException;
import com.birby.hrms.vo.JwtPrincipal;

import java.security.Principal;

public interface JwtPrincipalService {
    JwtPrincipal getJwtPrincipalData(Principal principal) throws PrincipalException;
}

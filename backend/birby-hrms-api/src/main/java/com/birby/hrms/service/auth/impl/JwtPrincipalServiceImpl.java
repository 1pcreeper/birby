package com.birby.hrms.service.auth.impl;

import com.birby.hrms.exception.PrincipalException;
import com.birby.hrms.service.auth.JwtPrincipalService;
import com.birby.hrms.vo.JwtPrincipal;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class JwtPrincipalServiceImpl implements JwtPrincipalService {
    @Override
    public JwtPrincipal getJwtPrincipalData(Principal principal) throws PrincipalException {
        try{
            return (JwtPrincipal) principal;
        } catch (RuntimeException e) {
            throw new PrincipalException("Principal Parse Failure");
        }
    }
}

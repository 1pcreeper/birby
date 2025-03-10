package com.birby.hrms_account_api.app.service.auth;

import com.birby.hrms_account_api.app.model.exception.PrincipalException;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface PrincipalService {
    Map<String,Object> getPrincipalData(Principal principal) throws PrincipalException;
    List<String> getRolesAsStringList(Principal principal) throws PrincipalException;
    String getId(Principal principal) throws PrincipalException;
    boolean hasRoles(Principal principal,List<String> roleIds) throws PrincipalException;
}

package com.birby.hrms_resource_api.service.auth;

import com.birby.hrms_resource_api.exception.PrincipalException;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface PrincipalService {
    Map<String,Object> getPrincipalData(Principal principal) throws PrincipalException;
    List<String> getRolesAsStringList(Principal principal) throws PrincipalException;
    boolean hasRoles(Principal principal,List<String> roles) throws PrincipalException;
}

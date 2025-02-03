package com.birby.hrms_resource_api.mapper;

import com.birby.hrms_resource_api.dto.response.AuthResDto;
import com.birby.hrms_resource_api.exception.PrincipalException;

import java.util.Map;

public interface AuthPrincipalMapper {
    AuthResDto toAuthResDto(Map<String,Object> principalData) throws PrincipalException;
}

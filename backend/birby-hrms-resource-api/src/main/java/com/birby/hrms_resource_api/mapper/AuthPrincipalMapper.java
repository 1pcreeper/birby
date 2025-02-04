package com.birby.hrms_resource_api.mapper;

import com.birby.hrms_resource_api.bo.response.AuthResBo;
import com.birby.hrms_resource_api.bo.response.RegisterResBo;
import com.birby.hrms_resource_api.dto.response.AuthResDto;
import com.birby.hrms_resource_api.exception.PrincipalException;

import java.util.Map;

public interface AuthPrincipalMapper {
    AuthResDto toAuthResDto(AuthResBo resBo) throws PrincipalException;
}

package com.birby.hrms_resource_api.mapper.impl;

import com.birby.hrms_resource_api.dto.response.AuthResDto;
import com.birby.hrms_resource_api.exception.PrincipalException;
import com.birby.hrms_resource_api.mapper.AuthPrincipalMapper;
import com.birby.hrms_resource_api.properties.FirebaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@EnableConfigurationProperties({FirebaseProperties.class})
public class AuthPrincipalMapperImpl implements AuthPrincipalMapper {
    private final FirebaseProperties firebaseProperties;
    @Autowired
    public AuthPrincipalMapperImpl(
            FirebaseProperties firebaseProperties
    ){
        this.firebaseProperties=firebaseProperties;
    }
    @Override
    public AuthResDto toAuthResDto(Map<String, Object> principalData) throws PrincipalException {
        final String UID_KEY = "uid";
        final String ROLES_KEY = firebaseProperties.getRolesClaim();

        try{
            AuthResDto resDto = new AuthResDto();
            resDto.setUid((String)principalData.get(UID_KEY));
            resDto.setRoles((List<String>)principalData.get(ROLES_KEY));
            return resDto;
        } catch (RuntimeException e) {
            throw new PrincipalException("Parse Principal Error");
        }
    }
}

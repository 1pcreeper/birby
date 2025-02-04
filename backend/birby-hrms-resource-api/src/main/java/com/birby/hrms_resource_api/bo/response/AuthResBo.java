package com.birby.hrms_resource_api.bo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResBo {
    private Map<String,Object> principalData;
    private String staffId;
}

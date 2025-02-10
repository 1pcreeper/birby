package com.birby.hrms_resource_api.bo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoResDto {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoleInfo{
        private String id;
        private String name;
        private String fullVocationName;
        private String vocationName;
        private String departmentName;
    }
    private List<RoleInfo> roleInfos;
}

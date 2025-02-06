package com.birby.hrms_resource_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffUpdateResDto {
    private String id;
    private String uid;
    private String name;
    private String email;
    private String displayName;
}

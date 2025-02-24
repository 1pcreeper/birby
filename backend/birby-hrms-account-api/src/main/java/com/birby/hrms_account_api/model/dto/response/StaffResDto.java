package com.birby.hrms_account_api.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffResDto {
    private String id;
    private String uid;
    private String name;
    private String email;
    private String displayName;
}

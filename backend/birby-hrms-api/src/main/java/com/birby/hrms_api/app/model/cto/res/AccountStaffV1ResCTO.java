package com.birby.hrms_api.app.model.cto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStaffV1ResCTO {
    private String id;
    private String uid;
    private String name;
    private String email;
    private String displayName;
}

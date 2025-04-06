package com.birby.hrms_api.app.model.cto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStaffRoleIdsV1ResCTO {
    private String staffId;
    private List<String> roleIds;
}

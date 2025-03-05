package com.birby.hrms_api.app.model.clidto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStaffRoleIdsResCliDto {
    private String staffId;
    private List<String> roleIds;
}

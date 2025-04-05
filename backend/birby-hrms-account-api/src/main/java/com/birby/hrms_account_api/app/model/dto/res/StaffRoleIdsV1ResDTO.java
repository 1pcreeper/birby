package com.birby.hrms_account_api.app.model.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffRoleIdsResDto {
    private String staffId;
    private List<String> roleIds;
}

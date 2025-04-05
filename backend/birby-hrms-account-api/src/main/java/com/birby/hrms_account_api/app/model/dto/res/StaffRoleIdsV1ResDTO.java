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
public class StaffRoleIdsV1ResDTO {
    private String staffId;
    private List<String> roleIds;
}

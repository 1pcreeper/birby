package com.birby.hrms.model.bo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStaffRoleIdsResCliBo {
    private String staffId;
    private List<String> roleIds;
}

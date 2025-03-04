package com.birby.hrms_account_api.model.clidto.req;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevokeReqCliDto {
    private String uid;
    private List<String> roleIds;
}

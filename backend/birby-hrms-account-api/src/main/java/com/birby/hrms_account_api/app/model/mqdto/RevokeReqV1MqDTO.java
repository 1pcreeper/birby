package com.birby.hrms_account_api.app.model.clidto.req;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevokeReqV1CliDTO {
    private String uid;
    private List<String> roleIds;
}

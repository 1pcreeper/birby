package com.birby.hrms_account_api.app.model.eto.req;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevokeV1ReqETO {
    private String uid;
    private List<String> roleIds;
}

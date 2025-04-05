package com.birby.hrms_account_api.app.model.mqdto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevokeReqV1MqDTO {
    private String uid;
    private List<String> roleIds;
}

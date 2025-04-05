package com.birby.hrms_account_api.app.model.clidto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FirebaseAuthCreateUserV1ReqCliDTO {
    private String displayName;
    private String email;
    private String password;
    private boolean disable;
    private boolean emailVerified;
    private String phoneNumber;
    private String photoUrl;
}

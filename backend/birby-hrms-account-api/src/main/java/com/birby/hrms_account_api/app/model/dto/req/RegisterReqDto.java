package com.birby.hrms_account_api.app.model.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterReqDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String displayName;
    @NotNull
    @NotBlank
    private String password;
}

package com.birby.hrms_account_api.app.model.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffRoleUpdateV1ReqDTO {
    @NotNull
    private List<String> roleIds;
}

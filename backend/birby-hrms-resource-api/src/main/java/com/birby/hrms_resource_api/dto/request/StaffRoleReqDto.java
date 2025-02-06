package com.birby.hrms_resource_api.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class StaffRoleReqDto {
    @NotNull
    @NotBlank
    private String staffId;
    @NotNull
    @NotBlank
    private List<String> roleIds;
}

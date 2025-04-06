package com.birby.hrms_api.app.model.eto.res;

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
public class RevokeV1ResETO {
    @NotNull
    @NotBlank
    private String uid;
    @NotNull
    private List<String> roleIds;
}

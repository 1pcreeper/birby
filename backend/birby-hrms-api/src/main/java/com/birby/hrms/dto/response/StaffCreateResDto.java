package com.birby.hrms.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffCreateResDto {
    private String name;
    private String displayName;
    private String email;
    private String staffId;
    private String uid;
    private String gender;
    private String birth;
    private String hkPhone;
    private String jobTypeName;
}

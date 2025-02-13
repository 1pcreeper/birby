package com.birby.hrms.dto.request;

import jakarta.annotation.Priority;
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
public class StaffCreateReqDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String displayName;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String gender;
    @NotNull
    private String birth;
    @NotNull
    @NotBlank
    private String hkPhone;
    @NotNull
    @NotBlank
    private String jobTypeId;

    public @NotNull @NotBlank String getName() {
        return name;
    }

    public void setName(@NotNull @NotBlank String name) {
        this.name = name;
    }

    public @NotNull @NotBlank String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(@NotNull @NotBlank String displayName) {
        this.displayName = displayName;
    }

    public @NotNull @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @NotBlank String password) {
        this.password = password;
    }

    public @NotNull @NotBlank String getGender() {
        return gender;
    }

    public void setGender(@NotNull @NotBlank String gender) {
        this.gender = gender;
    }

    public @NotNull String getBirth() {
        return birth;
    }

    public void setBirth(@NotNull String birth) {
        this.birth = birth;
    }

    public @NotNull @NotBlank String getHkPhone() {
        return hkPhone;
    }

    public void setHkPhone(@NotNull @NotBlank String hkPhone) {
        this.hkPhone = hkPhone;
    }

    public @NotNull @NotBlank String getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(@NotNull @NotBlank String jobTypeId) {
        this.jobTypeId = jobTypeId;
    }
}

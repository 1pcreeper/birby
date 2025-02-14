package com.birby.hrms.bo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceAuthResCliBo {
    private String uid;
    private String staffId;
    private List<String> roleIds;
    private String token;
    private String email;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public String getStaffId() {
        return staffId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public String getToken() {
        return token;
    }
}

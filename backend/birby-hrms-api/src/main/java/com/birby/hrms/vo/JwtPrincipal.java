package com.birby.hrms.vo;

import lombok.*;

import java.security.Principal;
import java.util.List;

@Data
@Builder
public class JwtPrincipal implements Principal {
    private final String name;
    private final String token;
    private final String uid;
    private final String staffId;
    private final List<String> roleIds;

    public JwtPrincipal(String name, String token, String uid, String staffId, List<String> roleIds) {
        this.name = name;
        this.token = token;
        this.uid = uid;
        this.staffId = staffId;
        this.roleIds = roleIds;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
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
}

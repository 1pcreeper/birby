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

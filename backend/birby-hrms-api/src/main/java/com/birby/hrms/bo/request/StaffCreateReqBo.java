package com.birby.hrms.bo.request;


import com.birby.hrms.model.StaffDetail;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffCreateReqBo {
    private ResourceRegisterReqCliBo resourceRegisterReqCliBo;
    private String token;
    private StaffDetail staffDetail;

    public ResourceRegisterReqCliBo getResourceRegisterReqCliBo() {
        return resourceRegisterReqCliBo;
    }

    public void setResourceRegisterReqCliBo(ResourceRegisterReqCliBo resourceRegisterReqCliBo) {
        this.resourceRegisterReqCliBo = resourceRegisterReqCliBo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StaffDetail getStaffDetail() {
        return staffDetail;
    }

    public void setStaffDetail(StaffDetail staffDetail) {
        this.staffDetail = staffDetail;
    }
}

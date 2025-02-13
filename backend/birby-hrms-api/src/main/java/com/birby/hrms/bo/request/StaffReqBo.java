package com.birby.hrms.bo.request;


import com.birby.hrms.model.Staff;
import com.birby.hrms.model.StaffDetail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffReqBo {
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

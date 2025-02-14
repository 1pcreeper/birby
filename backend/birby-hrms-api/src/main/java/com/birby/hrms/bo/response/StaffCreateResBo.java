package com.birby.hrms.bo.response;

import com.birby.hrms.model.StaffDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffCreateResBo {
    private StaffDetail staffDetail;
    private String email;
}

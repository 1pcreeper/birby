package com.birby.hrms_resource_api.model;

import com.birby.hrms_resource_api.model.id.StaffRoleId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staff_role")
public class StaffRole {
    @EmbeddedId
    private StaffRoleId id;
    @JoinColumn(name = "staff_id")
    @MapsId("staffId")
    @ManyToOne
    private Staff staff;
    @JoinColumn(name = "role_id")
    @MapsId("roleId")
    @ManyToOne
    private Role role;
}

package com.birby.hrms_account_api.model.entity;

import com.birby.hrms_account_api.model.entity.id.StaffRoleId;
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

    public StaffRoleId getId() {
        return id;
    }

    public void setId(StaffRoleId id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

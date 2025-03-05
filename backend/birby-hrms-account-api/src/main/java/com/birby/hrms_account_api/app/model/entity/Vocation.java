package com.birby.hrms_account_api.app.model.entity;

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
@Table(name = "vocation")
public class Vocation {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @JoinColumn(name = "depart_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
    @Column(name = "is_admin")
    private boolean isAdmin = false;
}
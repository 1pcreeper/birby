package com.birby.hrms_account_api.model;

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
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false, length = 20 , unique = true)
    private String name;
    @JoinColumn(name = "voc_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Vocation vocation;
}
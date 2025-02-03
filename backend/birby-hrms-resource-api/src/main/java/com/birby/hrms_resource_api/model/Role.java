package com.birby.hrms_resource_api.model;

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
    @Column(name = "id" , nullable = false)
    private String id;
    @Column(name = "name",nullable = false,length = 20)
    private String name;
    @JoinColumn(name="voc_id",nullable = false,unique = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private String vocId;
}
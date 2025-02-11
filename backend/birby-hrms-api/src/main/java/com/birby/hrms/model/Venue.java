package com.birby.hrms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venue")
public class Venue {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name="address",nullable = false)
    private String address;
    @Column(name = "staff_amount",nullable = false)
    private int staffAmount;
    @Column(name = "is_active")
    private boolean isActive = true;
}

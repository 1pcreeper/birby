package com.birby.hrms_resource_api.model;


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
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id" , nullable = false)
    private String id;
    @Column(name = "uid", unique = true ,nullable = false)
    private String uid;
    @Column(name = "name",unique = true, length = 20 , nullable = false)
    private String name;
    @Column(name="email", unique = true, length = 50 , nullable = false)
    private String email;
    @Column(name = "display_name" , length = 5 , nullable = false)
    private String displayName;
}

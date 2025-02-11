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
@Table(name = "request_method")
public class RequestMethod {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
}

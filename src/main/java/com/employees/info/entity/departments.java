package com.employees.info.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(length = 30, nullable = false, name = "department_name")
    private String departmentName;

    @Column(length = 11, name = "manager_id")
    private Long managerId;

    @Column(length = 11, name = "location_id")
    private Long locationId;
}

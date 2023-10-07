package com.employees.info.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "countries")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String countryId;

    @Column(length = 40, name = "country_name")
    private String countryName;

    @Column(length = 11, nullable = false, name = "region_id")
    private Long regionId;
}

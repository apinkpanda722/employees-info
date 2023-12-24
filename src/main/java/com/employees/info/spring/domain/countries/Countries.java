package com.employees.info.spring.domain.countries;

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
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String countryId;

    @Column(length = 40, name = "country_name")
    private String countryName;

    @Column(length = 11, nullable = false, name = "region_id")
    private Long regionId;
}

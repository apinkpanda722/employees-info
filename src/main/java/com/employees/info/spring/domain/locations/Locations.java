package com.employees.info.spring.domain.locations;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @Column(length = 40, name = "street_address")
    private String streetAddress;

    @Column(length = 12, name = "postal_code")
    private String postalCode;

    @Column(length = 30, nullable = false, name = "city")
    private String city;

    @Column(length = 25, name = "state_province")
    private String stateProvince;

    @Column(length = 2, nullable = false, name = "country_id")
    private String countryId;
}

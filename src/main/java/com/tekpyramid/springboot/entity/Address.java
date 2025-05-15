package com.tekpyramid.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    private String streetName;
    private String city;
    private String state;
    private String country;
    @OneToOne
    private Employee employee;

}

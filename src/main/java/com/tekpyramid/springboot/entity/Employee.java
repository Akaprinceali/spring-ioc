package com.tekpyramid.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String employeeName;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private double salary;
    private long mobile;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Address address;


}

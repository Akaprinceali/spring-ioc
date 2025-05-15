package com.tekpyramid.springboot.dto;

import lombok.Data;

@Data
public class AddressRequestDTO {

    private int employeeId;
    private String streetName;
    private String city;
    private String state;
    private String country;

}

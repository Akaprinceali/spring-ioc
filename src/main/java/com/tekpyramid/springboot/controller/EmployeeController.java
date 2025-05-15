package com.tekpyramid.springboot.controller;

import com.tekpyramid.springboot.dto.AddressDTO;
import com.tekpyramid.springboot.dto.EmployeeDTO;
import com.tekpyramid.springboot.response.ApiResponse;
import com.tekpyramid.springboot.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(
            summary = "Get mock employee data",
            description = "Returns a dummy EmployeeDTO object with pre-filled data for testing purposes"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "202", description = "Mock employee generated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDTO.class)))
    })
    @RequestMapping("/mock")
    public ResponseEntity<?> mockEmployee() {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCity("Chennai");
        addressDTO.setCountry("India");
        addressDTO.setState("Tamil Nadu");
        addressDTO.setStreetName("Any street");

        employeeDTO.setEmployeeName("Raju");
        employeeDTO.setEmail("raju@gmail.com");
        employeeDTO.setMobile(24345657654L);
        employeeDTO.setDateOfBirth(LocalDate.of(2000, 11, 4));
        employeeDTO.setSalary(15618.46);
        employeeDTO.setAddressDTO(addressDTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeDTO);
    }

    @Operation(
            summary = "Save new employee",
            description = "Accepts employee details and stores them in the database. Returns the saved employee's ID"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "202", description = "Employee saved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/save-employee")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        String id = employeeService.saveEmployee(employeeDTO);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("Employee saved successfully");
        apiResponse.setData(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }
}

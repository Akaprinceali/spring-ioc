package com.tekpyramid.springboot.service;

import com.tekpyramid.springboot.dto.EmployeeDTO;
import com.tekpyramid.springboot.entity.Address;
import com.tekpyramid.springboot.entity.Employee;
import com.tekpyramid.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO) {


        Address address = Address.builder()
                .state(employeeDTO.getAddressDTO().getState())
                .city(employeeDTO.getAddressDTO().getCity())
                .streetName(employeeDTO.getAddressDTO().getStreetName())
                .country(employeeDTO.getAddressDTO().getCountry())
                .build();

        Employee employee = Employee.builder()
                .employeeName(employeeDTO.getEmployeeName())
                .email(employeeDTO.getEmail())
                .dateOfBirth(employeeDTO.getDateOfBirth())
                .gender(employeeDTO.getGender())
                .mobile(employeeDTO.getMobile())
                .salary(employeeDTO.getSalary())
                .address(address)
                .build();

        address.setEmployee(employee);

        return employeeRepository.save(employee).getEmployeeId()+"";
    }
}

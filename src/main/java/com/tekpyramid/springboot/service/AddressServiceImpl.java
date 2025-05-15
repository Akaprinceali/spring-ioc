package com.tekpyramid.springboot.service;

import com.tekpyramid.springboot.dto.AddressRequestDTO;
import com.tekpyramid.springboot.entity.Address;
import com.tekpyramid.springboot.entity.Employee;
import com.tekpyramid.springboot.repository.AddressRepository;
import com.tekpyramid.springboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public String save(AddressRequestDTO addressRequestDTO) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(addressRequestDTO.getEmployeeId());

        if(optionalEmployee.isPresent()){

            Employee employee = optionalEmployee.get();

            Address address=new Address();

            BeanUtils.copyProperties(addressRequestDTO,address);

            address.setEmployee(employee);

            employee.setAddress(address);

            Employee saveEmployee = employeeRepository.save(employee);

            return saveEmployee.getAddress().getAddressId()+"";

        }

        return "Employee doesn't exist with this id";
    }
}

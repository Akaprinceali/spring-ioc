package com.tekpyramid.springboot.repository;

import com.tekpyramid.springboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}

package com.tekpyramid.springboot.service;

import com.tekpyramid.springboot.dto.AddressRequestDTO;

public interface AddressService {
    String save(AddressRequestDTO addressRequestDTO);
}

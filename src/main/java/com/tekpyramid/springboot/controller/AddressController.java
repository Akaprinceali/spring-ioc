package com.tekpyramid.springboot.controller;

import com.tekpyramid.springboot.dto.AddressRequestDTO;
import com.tekpyramid.springboot.response.ApiResponse;
import com.tekpyramid.springboot.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/save-address")
    public ResponseEntity<ApiResponse> saveAddress(@RequestBody AddressRequestDTO addressRequestDTO){

      String id = addressService.save(addressRequestDTO);

        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setHttpStatus(HttpStatus.ACCEPTED);
        apiResponse.setMessage("Address saves successfully");
        apiResponse.setData(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);

    }

}

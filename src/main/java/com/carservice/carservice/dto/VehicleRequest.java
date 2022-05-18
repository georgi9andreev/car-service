package com.carservice.carservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VehicleRequest {

    private String registrationNumber;
    private String model;
    private Integer yearOfManufacture;


}

package com.carservice.carservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DriverRequest {

    private String name;
    private String password;
    private String ucn;

    private Set<VehicleRequest> vehicleRequests;

}

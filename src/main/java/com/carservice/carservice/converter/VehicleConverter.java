package com.carservice.carservice.converter;

import com.carservice.carservice.dto.VehicleRequest;
import com.carservice.carservice.entity.Vehicle;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@Component
public class VehicleConverter {

    public Vehicle map(VehicleRequest vehicleRequest) {
        return Vehicle.builder()
                .registrationNumber(vehicleRequest.getRegistrationNumber())
                .model(vehicleRequest.getModel())
                .yearOfManufacture(vehicleRequest.getYearOfManufacture())
                .build();
    }
}

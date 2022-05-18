package com.carservice.carservice.converter;

import com.carservice.carservice.dto.DriverRequest;
import com.carservice.carservice.dto.VehicleRequest;
import com.carservice.carservice.entity.Driver;
import com.carservice.carservice.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverConverter {

    private VehicleConverter vehicleConverter;

    public Driver map (DriverRequest driverRequest){
          VehicleConverter vehicleConverter = new VehicleConverter();
       // Set<Vehicle> vehicles = new HashSet<>();
//        for (VehicleRequest vehicleRequest : driverRequest.getVehicleRequests()) {
//            Vehicle vehicle = vehicleConverter.map(vehicleRequest);
//            vehicles.add(vehicle);
//        }
        return Driver.builder()
                .name(driverRequest.getName())
                .ucn(driverRequest.getUcn())
                .password(driverRequest.getPassword())
                .vehicles(driverRequest.getVehicleRequests()
                        .stream()
                        .map(vehicleConverter::map)
                        .collect(Collectors.toSet()))
                .build();
    }
}

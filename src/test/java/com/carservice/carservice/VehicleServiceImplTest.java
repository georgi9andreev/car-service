package com.carservice.carservice;


import com.carservice.carservice.entity.Vehicle;
import com.carservice.carservice.repository.VehicleRepository;
import com.carservice.carservice.service.DriverService;
import com.carservice.carservice.service.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @Mock
    VehicleRepository vehicleRepository;
    @Mock
    DriverService driverService;

    private VehicleServiceImpl vehicleService;

    @BeforeEach
    public void setUp() {

        vehicleService = new VehicleServiceImpl(vehicleRepository, driverService);
    }

    @Test
    public void verifySave() {
        Vehicle expectedVehicle = Vehicle.builder()
                .id(1L)
                .typeOfVehicle("Car")
                .brand("Mercedes")
                .model("E500")
                .mileage(256333)
                .yearOfManufacture(2017)
                .dateOfRepair("23.04.2021")
                .build();
        Mockito.when(vehicleRepository.save(any(Vehicle.class)))
                .thenReturn(Vehicle.builder()
                        .id(1L)
                        .typeOfVehicle("Car")
                        .brand("Mercedes")
                        .model("E500")
                        .mileage(256333)
                        .yearOfManufacture(2017)
                        .dateOfRepair("23.04.2021")
                        .build());
        Vehicle actualVehicle = vehicleService.save(expectedVehicle);
        Mockito.verify(vehicleRepository, Mockito.times(1)).save(expectedVehicle);
        assertEquals(expectedVehicle.getId(), actualVehicle.getId());
        assertEquals(expectedVehicle.getBrand(), actualVehicle.getBrand());

    }

    @Test
    public void verifyFindByRegistrationNumber (){
        Mockito.when(vehicleRepository.findByRegistrationNumber(any(String.class)))
                .thenReturn(Set.of(Vehicle.builder().build()));
        Set<Vehicle> actual = vehicleRepository.findByRegistrationNumber("");
        Mockito.verify(vehicleRepository, Mockito.times(1)).findByRegistrationNumber(any(String.class));
        assertEquals(1, actual.size());
    }


    @Test
    public void verifyFindByDateOfRepair (){

        Mockito.when(vehicleRepository.findByDateOfRepair(any(String.class)))
                .thenReturn(Collections.singletonList(Vehicle.builder().build()));

        List<Vehicle> actual = vehicleRepository.findByDateOfRepair("");

        Mockito.verify(vehicleRepository, Mockito.times(1)).findByDateOfRepair(any(String.class));
        assertEquals(1, actual.size());
    }

}

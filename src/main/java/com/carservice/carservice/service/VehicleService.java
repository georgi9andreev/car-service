package com.carservice.carservice.service;

import com.carservice.carservice.entity.Vehicle;

import java.util.List;
import java.util.Set;


public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Set<Vehicle> findByRegistrationNumber (String registrationNumber);

    List<Vehicle> findByDateOfRepair (String dateOfRepair);


}

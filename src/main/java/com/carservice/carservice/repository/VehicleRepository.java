package com.carservice.carservice.repository;

import com.carservice.carservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface VehicleRepository extends JpaRepository <Vehicle, Long> {

    Set<Vehicle> findByRegistrationNumber (String registrationNumber);

    List<Vehicle> findByDateOfRepair (String dateOfRepair);
}

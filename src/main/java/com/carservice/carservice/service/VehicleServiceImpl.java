package com.carservice.carservice.service;

import com.carservice.carservice.entity.Driver;
import com.carservice.carservice.entity.Vehicle;
import com.carservice.carservice.exception.DuplicateRecordException;
import com.carservice.carservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final DriverService driverService;


    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, DriverService driverService) {
        this.vehicleRepository = vehicleRepository;
        this.driverService = driverService;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        Set<Driver> drivers = vehicle.getDrivers();
        for (Driver driver : drivers) {
            driverService.save(driver);
        }
        try {
            return vehicleRepository.save(vehicle);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Vehicle registration number : %s already exists.", vehicle.getRegistrationNumber())
            );
        }
    }

        @Override
        public Set<Vehicle> findByRegistrationNumber (String registrationNumber){
            return vehicleRepository.findByRegistrationNumber(registrationNumber);
        }

        @Override
        public List<Vehicle> findByDateOfRepair (String dateOfRepair){
            return vehicleRepository.findByDateOfRepair(dateOfRepair);
        }

    }


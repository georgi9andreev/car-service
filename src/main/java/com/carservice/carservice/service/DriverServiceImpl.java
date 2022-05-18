package com.carservice.carservice.service;

import com.carservice.carservice.converter.VehicleConverter;
import com.carservice.carservice.entity.Driver;
import com.carservice.carservice.entity.Vehicle;
import com.carservice.carservice.exception.DuplicateRecordException;
import com.carservice.carservice.exception.RecordNotFoundException;
import com.carservice.carservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Component
public class  DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final VehicleService vehicleService;

    @Autowired
    public DriverServiceImpl(final DriverRepository driverRepository, final VehicleService vehicleService) {
        this.driverRepository = driverRepository;
        this.vehicleService = vehicleService;
    }


    @Override
    public Driver save(Driver driver) {
        Set<Vehicle> vehicles = driver.getVehicles();
        for (Vehicle vehicle : vehicles) {
            vehicleService.save(vehicle);
        }
        try {
            return driverRepository.save(driver);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Driver name: %s already exists.", driver.getName())
            );

        }
    }

    @Override
    public List<Driver> findDriverByName(String name) {

        try {
            return driverRepository.findDriverByName(name);
        } catch (RecordNotFoundException ex) {
            throw new RecordNotFoundException(
                    String.format("Driver name: %s does not exist", name)
            );

        }
    }

    @Override
    public Set<Driver> findDriverByUcn(String driverUcn) {

        try {
            return driverRepository.findDriverByUcn(driverUcn);
        } catch (RecordNotFoundException ex) {
            throw new RecordNotFoundException(
                    String.format("Driver UCN: %s does not exist", driverUcn)
            );
        }
    }

    @Override
    public Driver findById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}

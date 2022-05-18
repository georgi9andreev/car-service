package com.carservice.carservice.service;

import com.carservice.carservice.entity.Driver;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface DriverService {

    Driver save(Driver driver);

    Driver findById (Long id);

    List<Driver> findDriverByName (String name);

    Set<Driver> findDriverByUcn (String driverUcn);
}

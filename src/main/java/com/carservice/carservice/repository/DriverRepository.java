package com.carservice.carservice.repository;

import com.carservice.carservice.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DriverRepository extends JpaRepository <Driver, Long> {


    List<Driver> findDriverByName (String name);

    Set<Driver> findDriverByUcn (String driverUcn);
}

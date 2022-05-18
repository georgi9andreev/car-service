package com.carservice.carservice;

import com.carservice.carservice.entity.Driver;
import com.carservice.carservice.repository.DriverRepository;
import com.carservice.carservice.service.DriverService;
import com.carservice.carservice.service.DriverServiceImpl;
import com.carservice.carservice.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class DriverServiceImplTest {

    @Mock
    private DriverRepository driverRepository;
    @Mock
    private VehicleService vehicleService;

   private DriverServiceImpl driverService;

    @BeforeEach
    public void setUp(){
        driverService = new DriverServiceImpl(driverRepository, vehicleService );
    }

    @Test
   public void verifySave (){
        Driver expectedDriver = Driver.builder()
                .id(1L)
                .name("Georgi")
                .password("1234")
                .ucn("9003065214")
                .build();
        Mockito.when(driverRepository.save(any(Driver.class)))
                .thenReturn(Driver.builder()
                        .id(1L)
                        .name("Georgi")
                        .password("1234")
                        .ucn("9003065214")
                        .build());

        Driver actualDriver = driverService.save(expectedDriver);

        Mockito.verify(driverRepository, Mockito.times(1)).save(expectedDriver);
       assertEquals(expectedDriver.getId(), actualDriver.getId());
        assertEquals(expectedDriver.getName(), actualDriver.getName());

    }

    @Test
    public void verifyFindDriverByName (){

        Mockito.when(driverRepository.findDriverByName(any(String.class)))
                .thenReturn(Collections.singletonList(Driver.builder().build()));

        List<Driver> actual = driverRepository.findDriverByName("");

        Mockito.verify(driverRepository, Mockito.times(1)).findDriverByName(any(String.class));
        assertEquals(1, actual.size());


    }

}

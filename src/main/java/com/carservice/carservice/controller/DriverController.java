package com.carservice.carservice.controller;


import com.carservice.carservice.converter.DriverConverter;
import com.carservice.carservice.dto.DriverRequest;
import com.carservice.carservice.dto.DriverResponse;
import com.carservice.carservice.entity.Driver;
import com.carservice.carservice.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/drivers")
public class DriverController {

    private final DriverService driverService;

    private final DriverConverter driverConverter;

    @PostMapping
    public ResponseEntity<DriverResponse> save(@RequestBody final DriverRequest driverRequest) {

        final Driver driver = driverConverter.map(driverRequest);
        final Driver saved = driverService.save(driver);

        return null;

    }

    @GetMapping ("/{id}")
    public ResponseEntity<HttpStatus> findById (@PathVariable Long id){
            Driver driver = driverService.findById (id);
                return ResponseEntity.ok(HttpStatus.OK);
    }
}

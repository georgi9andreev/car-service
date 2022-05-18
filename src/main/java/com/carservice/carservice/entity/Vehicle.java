package com.carservice.carservice.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehicles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true)
    private String registrationNumber;

    @Column (nullable = false)
    private String typeOfVehicle;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer yearOfManufacture;

    @Column (nullable = false)
    private Integer mileage;

    @Column (nullable = false)
    private String dateOfRepair;

    @JsonBackReference
    @ToString.Exclude
    @ManyToMany(mappedBy = "vehicles")
    private Set<Driver> drivers;

}

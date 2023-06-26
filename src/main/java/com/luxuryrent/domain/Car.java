package com.luxuryrent.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cars")
@Setter
public class Car {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "yearofprodcution")
    private int yearOfProduction;
    @Column(name = "color")
    private String color;
    @Column(name = "availability")
    private boolean available;
    @Column(name = "price")
    private double price;

    @Column(name = "mainImage", nullable = true)
    private String mainImage;


}

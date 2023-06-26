package com.luxuryrent.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class CarDTO {


    private long id;

    private String brand;

    private String model;

    private int yearOfProduction;

    private String color;

    private boolean available;

    private double price;

    private String mainImage;


}
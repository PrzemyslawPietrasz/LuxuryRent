package com.luxuryrent.controller;

import com.luxuryrent.domain.Car;
import com.luxuryrent.domain.CarDTO;
import com.luxuryrent.mapper.CarMapper;
import com.luxuryrent.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;


    @GetMapping
    public ResponseEntity<List<CarDTO>> getCars() {
        List<Car> tasks = carService.getAllCars();
        return ResponseEntity.ok(carMapper.mapToCarDTOList(tasks));
    }

    @GetMapping(value = "{carId}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long carId) throws CarNotFoundException {
        return new ResponseEntity<>(carMapper.mapToCarDTO(carService.getCar(carId)), HttpStatus.OK);
    }



    @DeleteMapping(value = "/{carId}")
    public void deleteTask(@PathVariable Long taskId) throws CarNotFoundException {

        if (taskId!=null){
            carService.deleteCar(taskId);}
        else {
            throw new CarNotFoundException();
        }
    }

    @PutMapping
    public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDTO) {
        Car car = carMapper.mapToCar(carDTO);
        Car savedCar = carService.addCar(car);
        return ResponseEntity.ok(carMapper.mapToCarDTO(savedCar));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody CarDTO carDTO) {
        carService.addCar(carMapper.mapToCar(carDTO));
    }


}


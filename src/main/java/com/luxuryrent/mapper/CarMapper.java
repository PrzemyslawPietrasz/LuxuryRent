package com.luxuryrent.mapper;

import com.luxuryrent.domain.Car;
import com.luxuryrent.domain.CarDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {


    public Car mapToCar (final CarDTO carDTO) {
        return new Car(carDTO.getId(), carDTO.getBrand(), carDTO.getModel(),carDTO.getYearOfProduction(),carDTO.getColor(), carDTO.isAvailable(), carDTO.getPrice(), carDTO.getMainImage());
    }

    public CarDTO mapToCarDTO (final Car car) {
        return new CarDTO(car.getId(), car.getBrand(), car.getModel(),car.getYearOfProduction(),car.getColor(), car.isAvailable(), car.getPrice(), car.getMainImage());
    }


    public List<CarDTO> mapToCarDTOList(final List<Car> carList) {
        return carList.stream()
                .map(t -> new CarDTO(t.getId(),t.getBrand(), t.getModel(), t.getYearOfProduction(),t.getColor(),t.isAvailable(),t.getPrice(),t.getMainImage()))
                .collect(Collectors.toList());
    }

    public List<CarDTO> mapCarDtoList(final List<Car> carList) {
        return carList.stream()
                .map(t -> new CarDTO(t.getId(),t.getBrand(), t.getModel(), t.getYearOfProduction(),t.getColor(),t.isAvailable(),t.getPrice(),t.getMainImage()))
                .collect(Collectors.toList());
    }
}
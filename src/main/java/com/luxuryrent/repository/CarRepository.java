package com.luxuryrent.repository;

import com.luxuryrent.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {


@Override
List<Car> findAll();

@Override
Car save(Car car);

@Override
Optional<Car> findById(Long id);

@Override
    void deleteById(Long id);


}

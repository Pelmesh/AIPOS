package com.example.sweater.repos;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.Check_Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo extends CrudRepository<Car, Long> {
    List<Car> findCarByIdCar(Integer idCar);
}

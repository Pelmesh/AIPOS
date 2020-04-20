package com.example.sweater.repos;

import com.example.sweater.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findAll();
    List<Car> findCarByIdCar(Integer idCar);
    Long deleteCarByIdCar(Integer idCar);
}

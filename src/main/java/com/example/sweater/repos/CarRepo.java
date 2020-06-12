package com.example.sweater.repos;

import com.example.sweater.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findAll();
    List<Car> findCarByIdCar(Integer idCar);

    @Query(value= "select distinct model_car from car", nativeQuery = true)
    List<String> searchModel();

    Long deleteCarByIdCar(Integer idCar);
}

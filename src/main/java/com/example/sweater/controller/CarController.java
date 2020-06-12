package com.example.sweater.controller;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CarRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarRepo carRepo;
    private Gson g = new Gson();

    @GetMapping
    public List<Car> findAllCar() {
        return carRepo.findAll();
    }

    @PostMapping
    public List<Car> addCar(
            @AuthenticationPrincipal User user,
            @RequestBody String jsonStr
    ) {
        JsonCar jsonCar = g.fromJson(jsonStr, JsonCar.class);
        Car car = new Car(jsonCar.modelCar,jsonCar.vin,jsonCar.number,user);
        carRepo.save(car);
        return carRepo.findAll();
    }

    @GetMapping("/{idCar}")
    public List<Car> findCarForEdit(@PathVariable Integer idCar, Model model) {
        return carRepo.findCarByIdCar(idCar);
    }

    @PutMapping("/{idCar}")
    public List<Car> carSave(
            @AuthenticationPrincipal User user,
            @RequestBody String jsonStr,
            @PathVariable Integer idCar
    ) {
        JsonCar jsonCar = g.fromJson(jsonStr, JsonCar.class);
        Car car = new Car(idCar,jsonCar.modelCar,jsonCar.number,jsonCar.vin,user);
        carRepo.save(car);
        return carRepo.findCarByIdCar(idCar);
    }

    @Modifying
    @Transactional
    @DeleteMapping("/{idCar}")
    public List<Car> deleteCar(
            @PathVariable Integer idCar
    ){
        carRepo.deleteCarByIdCar(idCar);
        return carRepo.findAll();
    }

    @GetMapping("model")
    public List<String> searchModel(
    ){
        return carRepo.searchModel();
    }




    class JsonCar {
        public String id;
        public String vin;
        public String number;
        public String modelCar;
    }
}

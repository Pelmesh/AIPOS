package com.example.sweater.controller;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CarRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CarController {
    @Autowired
    private CarRepo carRepo;


    @GetMapping("/car")
    public List<Car> read() {
        List<Car> car = carRepo.findAll();
        return car;
    }


    @PostMapping("/car")
    public List<Car> add(
            @AuthenticationPrincipal User user,
            @RequestBody String jsonStr
    ) {
        Gson g = new Gson();
        JsonCar jsonCar = g.fromJson(jsonStr, JsonCar.class);
        Car car = new Car(jsonCar.modelCar,jsonCar.vin,jsonCar.number,user);
        carRepo.save(car);
        return carRepo.findAll();
    }

    class JsonCar {
        public String vin;
        public String number;
        public String modelCar;
    }
}

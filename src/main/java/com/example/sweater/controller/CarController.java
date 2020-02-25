package com.example.sweater.controller;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CarController {
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/car")
    public String CarList(Model model) {
        model.addAttribute("cars",carRepo.findAll());
        return "car";
    }

   @PostMapping("/car")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String modelCar,
            @RequestParam String vin,
            @RequestParam String number,Map<String, Object> model
    ) {
        Car car = new Car(modelCar, vin,number, user);
        carRepo.save(car);
        Iterable<Car> cars = carRepo.findAll();
        model.put("cars", cars);
        return "car";
    }


}

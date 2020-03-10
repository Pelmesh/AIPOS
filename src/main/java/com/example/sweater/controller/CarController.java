package com.example.sweater.controller;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/car")
    public String CarList(Model model) {
        model.addAttribute("cars",carRepo.findAll());
        return "carFTHL/car";
    }

   @PostMapping("/car")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String modelCar,
            @RequestParam String vin,
            @RequestParam String number,Model model
    ) {
        if(modelCar.length()>0 && vin.length()>0 && number.length()>0) {
            Car car = new Car(modelCar, vin, number, user);
            carRepo.save(car);
        }
        model.addAttribute("cars",carRepo.findAll());
        return "carFTHL/car";
    }
}

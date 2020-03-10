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
@RequestMapping("/carList")
public class CarEditController {
    @Autowired
    CarRepo carRepo;

    @GetMapping
    public String CarEditController(Model model) {
        model.addAttribute("cars",carRepo.findAll());
        return "carFTHL/carList";
    }

    @GetMapping("{idCar}")
    public String carEdit(@PathVariable Integer idCar, Model model) {
        model.addAttribute("cars", carRepo.findCarByIdCar(idCar));
        return "carFTHL/carEdit";
    }

    @PostMapping("{idCar}")
    public String userSave(
            @RequestParam String vin,
            @RequestParam String number,
            @RequestParam String modelCar,
            @AuthenticationPrincipal User user,
            @PathVariable Integer idCar) {
        Car car = new Car(idCar,vin,number,modelCar,user);
        carRepo.save(car);
        return "redirect:/car";
    }
}

package com.example.sweater.controller;

import com.example.sweater.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carDelete")
public class CarDeleteController {
    @Autowired
    CarRepo carRepo;

    @Transactional
    @GetMapping("{idCar}")
    public String deleteCar(
            @PathVariable Integer idCar
    ){
        carRepo.deleteCarByIdCar(idCar);
        return "redirect:carFTHL/car";
    }

}

package com.example.sweater.controller;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarEditController {
    @Autowired
    CarRepo carRepo;

    /*@Transactional
    @DeleteMapping("{idCar}")
    public void deleteCar(
            @PathVariable Integer idCar
    ){
        carRepo.deleteCarByIdCar(idCar);
    //    return "redirect:carFTHL/car";
    }*/


    /*@GetMapping("{idCar}")
    public List<Car> carEdit(@PathVariable Integer idCar, Model model) {
        List<Car> car = carRepo.findCarByIdCar(idCar);
        return car;
    }*/

    /*@PostMapping("{idCar}")
    public String userSave(
            @RequestParam String vin,
            @RequestParam String number,
            @RequestParam String modelCar,
            @AuthenticationPrincipal User user,
            @PathVariable Integer idCar) {
        Car car = new Car(idCar,vin,number,modelCar,user);
        carRepo.save(car);
        return "redirect:/car";
    }*/
}

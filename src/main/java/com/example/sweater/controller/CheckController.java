package com.example.sweater.controller;

import com.example.sweater.domain.Check_Car;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CheckRepo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CheckController {
    @Autowired
    private CheckRepo checkRepo;

    @GetMapping("/check")
    public List<Check_Car> read() {
        List<Check_Car> check = checkRepo.findAll();
        return check;
    }

    @PostMapping("/check")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String ownerName, String vin,
            @RequestParam String result, Model model
    ) {
        if(ownerName.length()>0 && vin.length()>0) {
            Check_Car check = new Check_Car(ownerName, vin, result, user);
            checkRepo.save(check);
        }
        model.addAttribute("checks",checkRepo.findAll());
        return "check";
    }
}

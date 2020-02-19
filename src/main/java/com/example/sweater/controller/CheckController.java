package com.example.sweater.controller;

import com.example.sweater.domain.Car;
import com.example.sweater.domain.Check;
import com.example.sweater.domain.Owner;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CarRepo;
import com.example.sweater.repos.CheckRepo;
import com.example.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CheckController {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private OwnerRepo ownerRepo;
    @Autowired
    private CheckRepo checkRepo;

    @GetMapping("/check")
    public String main(Map<String, Object> model) {
        Iterable<Car> cars = carRepo.findAll();
        Iterable<Owner> owners = ownerRepo.findAll();
        model.put("cars", cars);
        model.put("owners", owners);
        return "check";
    }

    @PostMapping("/check")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String ownerName,String result,
            @RequestParam String engineNumber,Map<String, Object> model
    ) {
        Check check = new Check(ownerName, engineNumber,result, user);
        System.out.println("=========================================================");
        checkRepo.save(check);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Iterable<Check> checks = checkRepo.findAll();
        model.put("checks", checks);
        return "check";
    }
}

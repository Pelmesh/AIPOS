package com.example.sweater.controller;

import com.example.sweater.domain.Check_Car;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CheckRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/check")
public class CheckController {
    @Autowired
    private CheckRepo checkRepo;
    private Gson g = new Gson();

    @GetMapping
    public List<Check_Car> read() {
        List<Check_Car> check = checkRepo.findAll();
        return check;
    }

    @PostMapping
    public List<Check_Car> add(
            @AuthenticationPrincipal User user,
            @RequestBody String jsonStr
    ) {
        JsonCheck jsonCheck = g.fromJson(jsonStr, JsonCheck.class);
        Check_Car check = new Check_Car(jsonCheck.ownerName, jsonCheck.vin, jsonCheck.result, user);
        checkRepo.save(check);
        return checkRepo.findAll();
    }

    class JsonCheck {
        public String ownerName;
        public String vin;
        public String result;
    }
}

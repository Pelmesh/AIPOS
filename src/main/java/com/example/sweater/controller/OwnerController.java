package com.example.sweater.controller;

import com.example.sweater.domain.Owner;
import com.example.sweater.domain.User;
import com.example.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class OwnerController {
    @Autowired
    private OwnerRepo ownerRepo;

    @GetMapping("/owner")
    public String main(Map<String, Object> model) {
        Iterable<Owner> owners = ownerRepo.findAll();
        model.put("owners", owners);
        return "owner";
    }

    @PostMapping("/owner")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String ownerName,
            @RequestParam String year,Map<String, Object> model
    ) {
        Owner owner = new Owner(ownerName, year, user);
        ownerRepo.save(owner);
        Iterable<Owner> owners = ownerRepo.findAll();
        model.put("owners", owners);
        return "owner";
    }
}
package com.example.sweater.controller;

import com.example.sweater.domain.Owner;
import com.example.sweater.domain.User;
import com.example.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OwnerController {
    @Autowired
    private OwnerRepo ownerRepo;

    @GetMapping("/owner")
    public List<Owner> read() {
        List<Owner> owner = ownerRepo.findAll();
        return owner;
    }


    @PostMapping("/owner")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String ownerName,
            @RequestParam String year,Model model
    ) {
        if(ownerName.length()>0 && year.length()>0) {
            Owner owner = new Owner(ownerName, year, user);
            ownerRepo.save(owner);
        }
        model.addAttribute("owners", ownerRepo.findAll());
        return "ownerFTHL/owner";
    }
}
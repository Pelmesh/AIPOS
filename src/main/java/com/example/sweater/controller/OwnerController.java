package com.example.sweater.controller;

import com.example.sweater.domain.Owner;
import com.example.sweater.domain.User;
import com.example.sweater.repos.OwnerRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerRepo ownerRepo;
    private Gson g = new Gson();

    @GetMapping
    public List<Owner> findAllOwner() {
        List<Owner> owner = ownerRepo.findAll();
        return owner;
    }

    @PostMapping
    public List<Owner> addOwnder(
            @AuthenticationPrincipal User user,
            @RequestBody String jsonStr
    ) {
        JsonOwner jsonOwner = g.fromJson(jsonStr, JsonOwner.class);
        Owner owner = new Owner(jsonOwner.ownerName, jsonOwner.year, user);
        ownerRepo.save(owner);
        return  ownerRepo.findAll();
    }

    @GetMapping("{idOwner}")
    public List<Owner> carEdit(@PathVariable Integer idOwner) {
        return ownerRepo.findOwnerByIdOwner(idOwner);
    }

    @PutMapping("{idOwner}")
    public List<Owner> ownerSave(
            @AuthenticationPrincipal User user,
            @RequestBody String jsonStr,
            @PathVariable Integer idOwner
    ) {
        JsonOwner jsonOwner = g.fromJson(jsonStr, JsonOwner.class);
        Owner owner = new Owner(jsonOwner.ownerName, jsonOwner.year, idOwner, user);
        ownerRepo.save(owner);
        return ownerRepo.findOwnerByIdOwner(idOwner);
    }

    @Transactional
    @DeleteMapping("{idOwner}")
    public List<Owner> deleteOwner(
            @PathVariable Integer idOwner
    ) {
        ownerRepo.deleteOwnerByIdOwner(idOwner);
        return ownerRepo.findAll();
    }

    class JsonOwner {
        public String id;
        public String ownerName;
        public String year;
    }
}
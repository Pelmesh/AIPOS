package com.example.sweater.controller;

import com.example.sweater.domain.Owner;
import com.example.sweater.domain.User;
import com.example.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ownerList")
public class OwnerEditController {
    @Autowired
    OwnerRepo ownerRepo;

    @GetMapping
    public String OwnerEditController(Model model) {
        model.addAttribute("owners",ownerRepo.findAll());
        return "ownerFTHL/ownerList";
    }

    @GetMapping("{idOwner}")
    public String carEdit(@PathVariable Integer idOwner, Model model) {
        model.addAttribute("owners", ownerRepo.findOwnerByIdOwner(idOwner));
        return "ownerFTHL/ownerEdit";
    }

    @PostMapping("{idOwner}")
    public String userSave(
            @RequestParam String ownerName,
            @RequestParam String year,
            @AuthenticationPrincipal User user,
            @PathVariable Integer idOwner) {
        Owner owner = new Owner(ownerName,year,idOwner,user);
        ownerRepo.save(owner);
        return "redirect:/owner";
    }
}

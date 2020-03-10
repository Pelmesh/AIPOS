package com.example.sweater.controller;

import com.example.sweater.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ownerDelete")
public class OwnerDeleteController {
    @Autowired
    OwnerRepo ownerRepo;

    @Transactional
    @GetMapping("{idOwner}")
    public String deleteOwner(
            @PathVariable Integer idOwner
    ){
        ownerRepo.deleteOwnerByIdOwner(idOwner);
        return "redirect:ownerFTHL/owner";
    }
}

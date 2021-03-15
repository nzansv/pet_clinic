package com.example.petclinic.controller;

import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetOwnerController {
    @Autowired
    private PetOwnerService petOwnerService;

    public List<PetOwner> getAll() {
        return petOwnerService.getAll();
    }

    public void createPetOwner(PetOwner petOwner){
        petOwnerService.create(petOwner);
    }

    public PetOwner getPetOwnerById(Long id) {
        return petOwnerService.getById(id);
    }
}


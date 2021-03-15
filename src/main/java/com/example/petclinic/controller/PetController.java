package com.example.petclinic.controller;

import com.example.petclinic.entities.Pet;
import com.example.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    public List<Pet> getAll() {
        return petService.getAll();
    }

    public void createPet(Pet pet){
        petService.create(pet);
    }

    public Pet getPetById(Long id) {
        return petService.getById(id);
    }
}

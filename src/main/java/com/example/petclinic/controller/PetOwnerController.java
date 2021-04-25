package com.example.petclinic.controller;

import com.example.petclinic.entities.Appointment;
import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.repository.AppointmentRepository;
import com.example.petclinic.repository.PetOwnerRepository;
import com.example.petclinic.services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/petowners")
public class PetOwnerController {

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @GetMapping("")
    public List<PetOwner> getAllPetOwner() {
        return petOwnerRepository.findAll();
    }

    @GetMapping("/{id}")
    public PetOwner getPetOwnerById(@PathVariable("id") Long id) {
        return petOwnerRepository.findById(id).get();
    }

    @PostMapping("")
    public PetOwner createPetOwner(@RequestBody PetOwner petOwner) {
        return petOwnerRepository.saveAndFlush(petOwner);
    }

    @PutMapping("/{id}")
    public PetOwner updatePetOwner(@PathVariable Long id,
                                     @RequestBody PetOwner petOwner) {
        petOwner.setId(id);
        return petOwnerRepository.saveAndFlush(petOwner);
    }

    @DeleteMapping("/{id}")
    public void deletePetOwner(@PathVariable Long id){
        petOwnerRepository.deleteById(id);
    }

}



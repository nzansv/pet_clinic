package com.example.petclinic.controller;

import com.example.petclinic.entities.Pet;
import com.example.petclinic.repository.PetRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pets")
@Api(value = "Api Controller class")
public class PetController {

        @Autowired
        private PetRepository petRepository;

        @GetMapping("")
        public List<Pet> getAllPet() {
            return petRepository.findAll();
        }

        @GetMapping("/{id}")
        public Pet getPetById(@PathVariable("id") Long id) {
            return petRepository.findById(id).get();
        }

        @PostMapping("")
        public Pet createPet(@RequestBody Pet pet) {
            return petRepository.saveAndFlush(pet);
        }

        @PutMapping("/{id}")
        public Pet updatePet(@PathVariable Long id,
                                     @RequestBody Pet pet) {
            pet.setId(id);
            return petRepository.saveAndFlush(pet);
        }

        @DeleteMapping("/{id}")
        public void deletePet(@PathVariable Long id){
            petRepository.deleteById(id);
        }
    }

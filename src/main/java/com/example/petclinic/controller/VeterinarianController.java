package com.example.petclinic.controller;

import com.example.petclinic.entities.Pet;
import com.example.petclinic.entities.Veterinarian;
import com.example.petclinic.services.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;

    public List<Veterinarian> getAll(){
        return veterinarianService.getAll();
    }

    public void createVeterinarian(Veterinarian veterinarian){
        veterinarianService.create(veterinarian);
    }

    public Veterinarian getVeterinarianById(Long id) {
        return veterinarianService.getById(id);
    }
}

package com.example.petclinic.controller;

import com.example.petclinic.entities.Veterinarian;
import com.example.petclinic.repository.VeterinarianRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/veterinarians")
@Api(value = "Api Controller class")
public class VeterinarianController {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @GetMapping("")
    public List<Veterinarian> getAllVeterinarian() {
        return veterinarianRepository.findAll();
    }

    @GetMapping("/{id}")
    public Veterinarian getVeterinarianById(@PathVariable("id") Long id) {
        return veterinarianRepository.findById(id).get();
    }

    @PostMapping("")
    public Veterinarian createVeterinarian(@RequestBody Veterinarian veterinarian) {
        return veterinarianRepository.saveAndFlush(veterinarian);
    }

    @PutMapping("/{id}")
    public Veterinarian updateVeterinarian(@PathVariable Long id,
                         @RequestBody Veterinarian veterinarian) {
        veterinarian.setId(id);
        return veterinarianRepository.saveAndFlush(veterinarian);
    }

    @DeleteMapping("/{id}")
    public void deleteVeterinarian(@PathVariable Long id){
        veterinarianRepository.deleteById(id);
    }
}

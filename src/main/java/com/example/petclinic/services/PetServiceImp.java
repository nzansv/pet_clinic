package com.example.petclinic.services;

import com.example.petclinic.entities.Pet;
import com.example.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImp implements PetService{

    @Autowired
    private PetRepository petRepository;
    @Override
    public void create(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet getById(Long id) {
        return petRepository.getById(id);
    }
}

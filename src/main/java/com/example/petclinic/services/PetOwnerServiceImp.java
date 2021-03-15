package com.example.petclinic.services;

import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetOwnerServiceImp implements PetOwnerService{

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Override
    public void create(PetOwner petOwner) {
        petOwnerRepository.save(petOwner);
    }

    @Override
    public List<PetOwner> getAll() {
        return petOwnerRepository.findAll();
    }

    @Override
    public PetOwner getById(Long id) {
        return petOwnerRepository.getById(id);
    }
}

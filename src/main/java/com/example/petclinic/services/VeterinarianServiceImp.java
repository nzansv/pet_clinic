package com.example.petclinic.services;

import com.example.petclinic.entities.Veterinarian;
import com.example.petclinic.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianServiceImp implements VeterinarianService{

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Override
    public void create(Veterinarian veterinarian) {
        veterinarianRepository.save(veterinarian);
    }

    @Override
    public List<Veterinarian> getAll() {
        return veterinarianRepository.findAll();
    }

    @Override
    public Veterinarian getById(Long id) {
        return veterinarianRepository.getById(id);
    }
}

package com.example.petclinic.services;

import com.example.petclinic.entities.Veterinarian;

import java.util.List;

public interface VeterinarianService {
    void create(Veterinarian veterinarian);
    List<Veterinarian> getAll();
    Veterinarian getById(Long id);
}

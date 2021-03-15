package com.example.petclinic.services;
import com.example.petclinic.entities.Pet;
import org.springframework.data.domain.Page;
import java.util.*;


public interface PetService {

    void create(Pet pet);
    List<Pet> getAll();
    Pet getById(Long id);
}

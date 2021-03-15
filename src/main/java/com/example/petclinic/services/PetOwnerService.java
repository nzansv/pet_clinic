package com.example.petclinic.services;

import com.example.petclinic.entities.PetOwner;

import java.util.*;

public interface PetOwnerService {
    void create(PetOwner petOwner);
    List<PetOwner> getAll();
    PetOwner getById(Long id);
}

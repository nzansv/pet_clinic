package com.example.petclinic.repository;

import com.example.petclinic.entities.Pet;
import com.example.petclinic.entities.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet getById(Long id);
}

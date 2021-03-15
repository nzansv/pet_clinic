package com.example.petclinic.repository;

import com.example.petclinic.entities.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
    PetOwner getById(Long id);
}

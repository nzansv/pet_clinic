package com.example.petclinic.repository;

import com.example.petclinic.entities.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    Veterinarian getById(Long id);
}

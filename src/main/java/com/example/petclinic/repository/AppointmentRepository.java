package com.example.petclinic.repository;

import com.example.petclinic.entities.Appointment;
import com.example.petclinic.entities.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment getById(Long id);
}

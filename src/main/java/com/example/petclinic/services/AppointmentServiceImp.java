package com.example.petclinic.services;

import com.example.petclinic.entities.Appointment;
import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.entities.Veterinarian;
import com.example.petclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImp implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void create(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long id) {

        return appointmentRepository.getById(id);
    }
}


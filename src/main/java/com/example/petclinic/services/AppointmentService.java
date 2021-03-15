package com.example.petclinic.services;

import com.example.petclinic.entities.Appointment;
import java.util.List;

public interface AppointmentService {
    void create(Appointment appointment);
    List<Appointment> getAll();
    Appointment getById(Long id);
}

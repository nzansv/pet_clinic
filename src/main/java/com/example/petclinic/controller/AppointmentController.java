package com.example.petclinic.controller;

import com.example.petclinic.entities.Appointment;
import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.services.AppointmentService;
import com.example.petclinic.services.AppointmentServiceImp;
import com.example.petclinic.services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    public List<Appointment> getAll() {
        return appointmentService.getAll();
    }

    public void createAppointment(Appointment appointment){
        appointmentService.create(appointment);
    }

    public Appointment getcreateAppointmentById(Long id) {
        return appointmentService.getById(id);
    }
}

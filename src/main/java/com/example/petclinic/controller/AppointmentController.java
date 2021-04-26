package com.example.petclinic.controller;

import com.example.petclinic.entities.Appointment;
import com.example.petclinic.repository.AppointmentRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@Api(value = "Api Controller class")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("")
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable("id") Long id) {
        return appointmentRepository.findById(id).get();
    }

    @PostMapping("")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.saveAndFlush(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id,
                                 @RequestBody Appointment appointment) {
        appointment.setId(id);
        return appointmentRepository.saveAndFlush(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentRepository.deleteById(id);
    }

}

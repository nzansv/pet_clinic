package com.example.petclinic.controller;

import com.example.petclinic.entities.Appointment;
import com.example.petclinic.entities.Payment;
import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.repository.AppointmentRepository;
import com.example.petclinic.repository.PaymentRepository;
import com.example.petclinic.services.PaymentService;
import com.example.petclinic.services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("")
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        return paymentRepository.findById(id).get();
    }

    @PostMapping("")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.saveAndFlush(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id,
                                     @RequestBody Payment payment) {
        payment.setId(id);
        return paymentRepository.saveAndFlush(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id){
        paymentRepository.deleteById(id);
    }

}

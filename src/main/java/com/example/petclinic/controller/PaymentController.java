package com.example.petclinic.controller;

import com.example.petclinic.entities.Payment;
import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.services.PaymentService;
import com.example.petclinic.services.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    public void createPayment(Payment payment){
        paymentService.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentService.getById(id);
    }
}

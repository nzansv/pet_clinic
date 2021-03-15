package com.example.petclinic.services;

import com.example.petclinic.entities.Payment;

import java.util.List;

public interface PaymentService {
    void create(Payment payment);
    List<Payment> getAll();
    Payment getById(Long id);
    void update(Long id, Payment payment);
}

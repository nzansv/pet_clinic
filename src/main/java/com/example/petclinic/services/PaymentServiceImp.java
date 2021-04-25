package com.example.petclinic.services;

import com.example.petclinic.entities.Payment;
import com.example.petclinic.event.PaymentCreateEvent;
import com.example.petclinic.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImp implements PaymentService{

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void update(Long id, Payment payment) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);

        if (paymentOptional.isPresent()) {
            Payment dbPayment = paymentOptional.get();
            dbPayment.setStatus(payment.getStatus());

            paymentRepository.save(dbPayment);
        }
    }

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void create(Payment payment) {
        paymentRepository.save(payment);

    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.getById(id);
    }
}

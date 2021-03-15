package com.example.petclinic.repository;
import com.example.petclinic.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment getById(Long id);

}

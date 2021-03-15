package com.example.petclinic.event;

import com.example.petclinic.entities.Payment;
import org.springframework.context.ApplicationEvent;

public class PaymentCreateEvent extends ApplicationEvent {

    private Payment payment;

    public PaymentCreateEvent(Object source, Payment payment){
        super(source);
        this.payment=payment;
    }

    public Payment getPayment() {
        return payment;
    }
}

package com.example.petclinic.event.handler;

import com.example.petclinic.event.PaymentCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentCreateHandler implements ApplicationListener<PaymentCreateEvent> {
    @Override
    public void onApplicationEvent(PaymentCreateEvent paymentCreateEvent) {
        System.out.println("PaymentCreateHandler.onApplicationEvent");
        System.out.println("Created payment info: " + paymentCreateEvent.getPayment());

    }
}

package com.fiapfood.order.adapters.outbound.rest;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class PaymentRest {

    public boolean paymentStratus(){
        Random random = new Random();
        return random.nextBoolean();
    }
}

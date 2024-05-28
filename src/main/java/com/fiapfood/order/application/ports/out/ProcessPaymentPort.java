package com.fiapfood.order.application.ports.out;

import com.fiapfood.order.application.core.domain.Payment;

public interface ProcessPaymentPort {

    Payment processPayment(Payment payment);
}

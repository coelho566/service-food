package com.fiapfood.order.adapters.outbound;

import com.fiapfood.order.adapters.outbound.rest.PaymentRest;
import com.fiapfood.order.application.core.domain.Payment;
import com.fiapfood.order.application.core.domain.PaymentEnum;
import com.fiapfood.order.application.ports.out.ProcessPaymentPort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessPaymentAdapter implements ProcessPaymentPort {

    PaymentRest paymentRest;

    public ProcessPaymentAdapter(PaymentRest paymentRest) {
        this.paymentRest = paymentRest;
    }

    @Override
    public Payment processPayment(Payment payment) {

        if (paymentRest.paymentStratus()) {
            return new Payment(payment.getMethod(), PaymentEnum.APROVADO, payment.getDetails());
        } else {
            return new Payment(payment.getMethod(), PaymentEnum.REPROVADO, payment.getDetails());
        }
    }
}

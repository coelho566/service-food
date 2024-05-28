package com.fiapfood.order.application.core.usecase;

import com.fiapfood.order.application.core.domain.Order;
import com.fiapfood.order.application.core.domain.PaymentEnum;
import com.fiapfood.order.application.ports.in.OrderUseCasePort;
import com.fiapfood.order.application.ports.out.OrderRepositoryPort;
import com.fiapfood.order.application.ports.out.ProcessPaymentPort;

import java.util.List;

public class OrderUseCase implements OrderUseCasePort {

    private OrderRepositoryPort orderRepositoryPort;
    private ProcessPaymentPort processPaymentPort;

    public OrderUseCase(OrderRepositoryPort orderRepositoryPort, ProcessPaymentPort processPaymentPort) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.processPaymentPort = processPaymentPort;
    }

    @Override
    public String checkoutOrder(Order order) {

        var payment = processPaymentPort.processPayment(order.getPayment());
        order.setPayment(payment);
        orderRepositoryPort.insertOrder(order);
        if(payment.getStatus().equals(PaymentEnum.APROVADO))
            return "Pagamento aprovado, pedido enviado para cozinha.";
        else
            return "Pagamento reprovado!";
    }

    @Override
    public List<Order> listOrder() {
        return orderRepositoryPort.listOrders();
    }
}

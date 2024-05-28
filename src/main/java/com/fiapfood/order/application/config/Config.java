package com.fiapfood.order.application.config;

import com.fiapfood.order.application.core.usecase.OrderUseCase;
import com.fiapfood.order.application.ports.out.OrderRepositoryPort;
import com.fiapfood.order.application.ports.out.ProcessPaymentPort;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;

@Dependent
public class Config {

    @Default
    public OrderUseCase orderUseCase(OrderRepositoryPort orderRepositoryPort, ProcessPaymentPort processPaymentPort){
        return new OrderUseCase(orderRepositoryPort, processPaymentPort);
    }
}

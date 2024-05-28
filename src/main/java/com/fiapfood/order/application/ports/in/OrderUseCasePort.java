package com.fiapfood.order.application.ports.in;

import com.fiapfood.order.application.core.domain.Order;

import java.util.List;

public interface OrderUseCasePort {

    String checkoutOrder(Order order);

    List<Order> listOrder();
}

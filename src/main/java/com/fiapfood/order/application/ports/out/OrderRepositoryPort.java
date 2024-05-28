package com.fiapfood.order.application.ports.out;

import com.fiapfood.order.application.core.domain.Order;

import java.util.List;

public interface OrderRepositoryPort {

    void insertOrder(Order order);
    List<Order> listOrders();
}

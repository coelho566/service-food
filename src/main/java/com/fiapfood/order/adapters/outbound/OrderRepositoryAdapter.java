package com.fiapfood.order.adapters.outbound;

import com.fiapfood.order.adapters.inbound.entity.OrderEntity;
import com.fiapfood.order.adapters.inbound.mapper.OrderMapper;
import com.fiapfood.order.adapters.outbound.repository.OrderRepository;
import com.fiapfood.order.application.core.domain.Order;
import com.fiapfood.order.application.ports.out.OrderRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderRepositoryAdapter implements OrderRepositoryPort {

    OrderRepository orderRepository;
    OrderMapper orderMapper;

    public OrderRepositoryAdapter(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public void insertOrder(Order order) {
        var newOrder = orderMapper.orderToOrderEntity(order);
        orderRepository.persist(newOrder);
    }

    @Override
    public List<Order> listOrders() {
        var orderEntities = orderRepository.listAll();
        return orderEntities.stream()
                .map(order -> orderMapper.orderEntityToOrder(order)).collect(Collectors.toList());
    }
}

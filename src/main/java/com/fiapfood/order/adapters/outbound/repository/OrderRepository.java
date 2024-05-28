package com.fiapfood.order.adapters.outbound.repository;

import com.fiapfood.order.adapters.inbound.entity.OrderEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheMongoRepository<OrderEntity> {
}

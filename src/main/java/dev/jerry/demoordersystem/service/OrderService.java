package dev.jerry.demoordersystem.service;

import dev.jerry.demoordersystem.entity.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {
    Collection<Order> findAll();
    Optional<Order> findById(long id);
    Order create(Order order);
    void update(Order order, long id);
    void deleteById(long id);
}

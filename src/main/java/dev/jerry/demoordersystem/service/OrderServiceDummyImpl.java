package dev.jerry.demoordersystem.service;

import dev.jerry.demoordersystem.model.Item;
import dev.jerry.demoordersystem.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


public class OrderServiceDummyImpl implements OrderService {

    private final Collection<Order> orders;

    public OrderServiceDummyImpl() {
        orders = new ArrayList<>();
        loadTestData();
    }

    private void loadTestData() {
        Item item1 = new Item();
        item1.setName("item1");
        item1.setUnitPrice(new BigDecimal("20.54"));
        item1.setQuantity(10);

        Item item2 = new Item();
        item2.setName("item2");
        item2.setUnitPrice(new BigDecimal("20.54"));
        item2.setQuantity(8);

        Item item3 = new Item();
        item3.setName("item3");
        item3.setUnitPrice(new BigDecimal("100.21"));
        item3.setQuantity(20);

        Order order1 = new Order();
        order1.addItem(item1);
        order1.setTotalPrice(new BigDecimal("205.4"));

        Order order2 = new Order();
        order2.addItem(item2);
        order2.addItem(item3);
        order2.setTotalPrice(new BigDecimal("2168.52"));

        orders.add(order1);
        orders.add(order2);
    }


    @Override
    public Collection<Order> findAll() {
        return orders;
    }

    @Override
    public Optional<Order> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public void update(Order order, long id) {

    }

    @Override
    public void deleteById(long id) {

    }
}

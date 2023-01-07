package dev.jerry.demoordersystem.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.TreeSet;

@Entity
public class Item implements Serializable, Comparable<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal unitPrice;
    private int quantity;

    @ManyToMany
    private Collection<Order> orders;

    public Item() {
        orders = new TreeSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        unitPrice.setScale(2, RoundingMode.DOWN);
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        getOrders().add(order);
        order.getItems().add(this);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", orders=" + orders +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return Long.compare(getId(), o.getId());
    }
}

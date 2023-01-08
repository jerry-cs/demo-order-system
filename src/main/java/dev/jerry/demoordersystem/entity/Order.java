package dev.jerry.demoordersystem.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.TreeSet;

@Entity
public class Order implements Serializable, Comparable<Order> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal totalPrice;

    @OneToMany
    private Collection<Item> items;

    public Order() {
        items = new TreeSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        totalPrice.setScale(2, RoundingMode.DOWN);
        this.totalPrice = totalPrice;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        getItems().add(item);
        item.setOrder(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return Long.compare(getId(), o.getId());
    }
}

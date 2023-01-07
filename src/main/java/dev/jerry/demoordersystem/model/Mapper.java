package dev.jerry.demoordersystem.model;

import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
public class Mapper {
    public OrderDTO toDto(Order order) {
        Collection<ItemDTO> items = order.getItems().stream().map(this::toDto).collect(toList());
        return new OrderDTO(order.getId(), order.getTotalPrice(), items);
    }

    public ItemDTO toDto(Item item) {
        return new ItemDTO(item.getName(), item.getUnitPrice(), item.getQuantity());
    }
}

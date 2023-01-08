package dev.jerry.demoordersystem.model;

import dev.jerry.demoordersystem.util.Calculator;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

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

    public Order toOrder(OrderCreationDTO orderCreationDTO) {
        Order order = new Order();
        order.setTotalPrice(Calculator.calcTotalPrice(orderCreationDTO.items()));
        order.setItems(orderCreationDTO.items().stream().map(this::toItem).collect(Collectors.toSet()));
        return order;
    }

    public Item toItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.name());
        item.setQuantity(itemDTO.quantity());
        item.setUnitPrice(itemDTO.unitPrice());
        return item;
    }
}

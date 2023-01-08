package dev.jerry.demoordersystem.util;

import dev.jerry.demoordersystem.model.ItemDTO;

import java.math.BigDecimal;
import java.util.Collection;

public class Calculator {
    public static BigDecimal calcTotalPrice(Collection<ItemDTO> items) {
        return items.stream()
                .map( (item) -> item.unitPrice().multiply(BigDecimal.valueOf(item.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

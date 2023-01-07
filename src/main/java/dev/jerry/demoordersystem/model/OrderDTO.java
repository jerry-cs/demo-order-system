package dev.jerry.demoordersystem.model;

import java.math.BigDecimal;
import java.util.Collection;

public record OrderDTO(long id, BigDecimal totalAmount, Collection<ItemDTO> items) { }

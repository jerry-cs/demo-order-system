package dev.jerry.demoordersystem.model;

import java.math.BigDecimal;

public record ItemDTO(String name, BigDecimal unitPrice, int quantity) {}

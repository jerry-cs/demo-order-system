package dev.jerry.demoordersystem.model;

import java.util.Collection;

public record OrderCreationRequestDTO(Collection<ItemDTO> items) { }

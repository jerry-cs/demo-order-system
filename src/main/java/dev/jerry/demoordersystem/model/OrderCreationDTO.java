package dev.jerry.demoordersystem.model;

import java.util.Collection;

public record OrderCreationDTO(Collection<ItemDTO> items) { }

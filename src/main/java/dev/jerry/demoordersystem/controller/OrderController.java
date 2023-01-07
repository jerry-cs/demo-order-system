package dev.jerry.demoordersystem.controller;

import dev.jerry.demoordersystem.exception.OrderNotFoundException;
import dev.jerry.demoordersystem.model.Mapper;
import dev.jerry.demoordersystem.model.Order;
import dev.jerry.demoordersystem.model.OrderDTO;
import dev.jerry.demoordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    @Qualifier(value = "orderServiceInCache")
    private OrderService orderService;

    @Autowired
    private Mapper mapper;

    public OrderController() { }

    @GetMapping
    public List<OrderDTO> findAll() {
        return orderService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable("id") long id) throws OrderNotFoundException {
        Order existing = orderService.findById(id).orElseThrow(()-> new OrderNotFoundException("Cannot find Order of id: " + id));
        return mapper.toDto(existing);
    }

}

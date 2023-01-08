package dev.jerry.demoordersystem.controller;

import dev.jerry.demoordersystem.exception.OrderNotFoundException;
import dev.jerry.demoordersystem.model.Mapper;
import dev.jerry.demoordersystem.model.Order;
import dev.jerry.demoordersystem.model.OrderCreationDTO;
import dev.jerry.demoordersystem.model.OrderDTO;
import dev.jerry.demoordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderDTO create(@RequestBody OrderCreationDTO orderCreationDTO) {
        Order order = mapper.toOrder(orderCreationDTO);
        orderService.create(order);
        return mapper.toDto(order);
    }

}

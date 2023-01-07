package dev.jerry.demoordersystem.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceDummyImplFactory {

    @Bean
    public OrderService orderServiceInCache() {
        return new OrderServiceDummyImpl();
    }
}

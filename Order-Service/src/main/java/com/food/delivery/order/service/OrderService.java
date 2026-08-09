package com.food.delivery.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.food.delivery.order.entity.Order;
import com.food.delivery.order.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public Optional<Order> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
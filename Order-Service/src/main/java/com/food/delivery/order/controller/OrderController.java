package com.food.delivery.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.delivery.order.entity.Order;
import com.food.delivery.order.service.OrderService;

@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return service.getAllOrders();
    }

    @PostMapping("/orders")
    public Order newOrder(@RequestBody Order order) {
        return service.save(order);
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> one(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping("/orders/{id}")
    public Order replaceOrder(@RequestBody Order newOrder,
                              @PathVariable Integer id) {

        return service.findById(id)
                .map(order -> {
                    order.setCustomerName(newOrder.getCustomerName());
                    order.setRestaurantId(newOrder.getRestaurantId());
                    order.setFoodItem(newOrder.getFoodItem());
                    order.setQuantity(newOrder.getQuantity());
                    order.setTotalAmount(newOrder.getTotalAmount());
                    order.setStatus(newOrder.getStatus());
                    return service.save(order);
                })
                .orElseGet(() -> service.save(newOrder));
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
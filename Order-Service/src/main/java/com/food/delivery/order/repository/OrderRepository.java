package com.food.delivery.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.food.delivery.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
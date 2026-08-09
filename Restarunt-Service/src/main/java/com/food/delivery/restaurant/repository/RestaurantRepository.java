package com.food.delivery.restaurant.repository; 
 
import org.springframework.data.jpa.repository.JpaRepository; 
 
import com.food.delivery.restaurant.entity.Restaurant; 
 
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{ 
 
} 

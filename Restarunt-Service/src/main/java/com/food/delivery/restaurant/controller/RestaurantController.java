package com.food.delivery.restaurant.controller; 
 
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController; 
 
import com.food.delivery.restaurant.entity.Restaurant; 
import com.food.delivery.restaurant.service.RestaurantService; 
 
@RestController 
public class RestaurantController { 
    private final RestaurantService service; 
 
    public RestaurantController(RestaurantService service) { 
        this.service = service; 
    } 
 
    @GetMapping("/restaurants") 
    public List<Restaurant> getRestaurants() { 
        return service.getAllRestaurants(); 
    } 
     
    @PostMapping("/restaurants") 
    Restaurant newRestaurant(@RequestBody Restaurant newRestaurant) { 
      return service.save(newRestaurant); 
    } 
 
    // Single item 
     
    @GetMapping("/restaurants/{id}") 
    Optional<Restaurant> one(@PathVariable int id) { 
       
      return service.findById(id); 
    } 
     
    @PutMapping("/restaurants/{id}") 
    Restaurant replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable int 
id) { 
       
      return service.findById(id) 
        .map(restaurant -> { 
          restaurant.setName(newRestaurant.getName()); 
          restaurant.setLocation(newRestaurant.getLocation()); 
          return service.save(restaurant); 
        }) 
        .orElseGet(() -> { 
          return service.save(newRestaurant); 
        }); 
    } 
 
   @DeleteMapping("/restaurants/{id}") 
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Integer id) { 
        service.deleteById(id); 
        return ResponseEntity.noContent().build(); // 204 No Content 
    } 
}
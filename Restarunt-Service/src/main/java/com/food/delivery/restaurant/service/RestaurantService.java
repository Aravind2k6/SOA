package com.food.delivery.restaurant.service; 
 
import java.util.*; 
 
import org.springframework.stereotype.Service; 
 
import com.food.delivery.restaurant.entity.Restaurant; 
import com.food.delivery.restaurant.repository.RestaurantRepository; 
 
@Service 
public class RestaurantService { 
    private final RestaurantRepository repository; 
 
    public RestaurantService(RestaurantRepository repository) { 
        this.repository = repository; 
    } 
 
    public List<Restaurant> getAllRestaurants() { 
        return repository.findAll(); 
    } 
 
 public Restaurant save(Restaurant newRestaurant) { 
  // TODO Auto-generated method stub 
  return repository.save(newRestaurant); 
 } 
 
 public Optional<Restaurant> findById(Integer id) { 
     return repository.findById(id); // JPA returns Optional 
 } 
 
 public void deleteById(Integer id) { 
          repository.deleteById(id); 
     } 
} 
package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping
    public List<Cart> getAllCartItems() {
        return service.getAllCartItems();
    }

    @GetMapping("/{id}")
    public Cart getCartItem(@PathVariable Integer id) {
        return service.getCartItemById(id);
    }

    @PostMapping
    public Cart addCartItem(@RequestBody Cart cart) {
        return service.saveCartItem(cart);
    }

    @PutMapping
    public Cart updateCartItem(@RequestBody Cart cart) {
        return service.updateCartItem(cart);
    }

    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable Integer id) {
        service.deleteCartItem(id);
        return "Cart Item Deleted Successfully";
    }
}
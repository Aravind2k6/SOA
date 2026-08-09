package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public List<Cart> getAllCartItems() {
        return repository.findAll();
    }

    public Cart getCartItemById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Cart saveCartItem(Cart cart) {
        return repository.save(cart);
    }

    public Cart updateCartItem(Cart cart) {
        return repository.save(cart);
    }

    public void deleteCartItem(Integer id) {
        repository.deleteById(id);
    }
}
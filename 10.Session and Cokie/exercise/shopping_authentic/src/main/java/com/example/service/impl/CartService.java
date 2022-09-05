package com.example.service.impl;

import com.example.model.Product;
import com.example.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {
    @Override
    public void addToCart(Product product, Map<Product, Integer> cart) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    @Override
    public double payment(Map<Product, Integer> cart) {
        double payment =0;
        for (Product p: cart.keySet()) {
            payment += p.getPrice() * cart.get(p);
        }
        return payment;
    }

    @Override
    public void changeQuantity(Product product, Map<Product, Integer> cart, String operand) {
        if (operand.equals("+")){
            cart.put(product,cart.get(product)+1);
        } else if (operand.equals("-")) {
            cart.put(product,cart.get(product)-1);
        }
        if (cart.get(product)==0) {
            cart.remove(product);
        }
    }

    @Override
    public void delete(Product product, Map<Product, Integer> cart) {
        cart.remove(product);
    }
}

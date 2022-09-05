package com.example.service.impl;

import com.example.model.Product;
import com.example.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {

    @Override
    public void addProduct(Map<Product,Integer> cart,Product product) {
        if (cart.containsKey(product)) {
            cart.put(product,cart.get(product) +1);
        } else {
            cart.put(product,1);
        }
    }


    @Override
    public double countTotalPayment(Map<Product,Integer> cart) {
        double payment = 0;
        for (Product p: cart.keySet()) {
            payment += p.getPrice()*cart.get(p);
        }
        return payment;
    }

}


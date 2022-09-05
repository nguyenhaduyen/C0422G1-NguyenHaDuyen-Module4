package com.example.service;

import com.example.model.Product;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

public interface ICartService {
    void addToCart(Product product, Map<Product, Integer> cart);

    double payment(Map<Product, Integer> cart);

    void changeQuantity (Product product,Map<Product,Integer> cart,String operand);

    void delete(Product product,Map<Product,Integer> cart);
}

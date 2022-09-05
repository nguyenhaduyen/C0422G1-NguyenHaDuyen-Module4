package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll(String name);

    void delete(int id);

    void update(Product product);

    Product findById(int id);

    void create(Product product);
}

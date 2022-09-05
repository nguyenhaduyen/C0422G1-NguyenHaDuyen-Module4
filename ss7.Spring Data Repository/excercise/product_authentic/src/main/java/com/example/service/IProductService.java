package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {

    void delete(int id);

    void update(Product product);

    Optional<Product> findById(int id);

    void create(Product product);

    Page<Product> findAllByNameOfProduct(String name, Pageable pageable);
}

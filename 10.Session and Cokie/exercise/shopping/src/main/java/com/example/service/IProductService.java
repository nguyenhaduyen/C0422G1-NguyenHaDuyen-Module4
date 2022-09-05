package com.example.service;

import com.example.model.Product;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findId(int id);
}

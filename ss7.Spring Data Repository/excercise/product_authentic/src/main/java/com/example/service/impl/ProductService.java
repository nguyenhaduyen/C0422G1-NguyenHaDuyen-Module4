package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void delete(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void create(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Page<Product> findAllByNameOfProduct(String name, Pageable pageable) {
        return iProductRepository.findAllByNameOfProductContaining(name, pageable);
    }
}

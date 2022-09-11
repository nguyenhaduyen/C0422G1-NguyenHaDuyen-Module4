package com.example.customer.service.impl;

import com.example.customer.model.TypeCustomer;
import com.example.customer.repository.ITypeCustomerRepository;
import com.example.customer.service.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerService implements ITypeCustomerService {
    @Autowired
    private ITypeCustomerRepository iTypeCustomerRepository;
    @Override
    public List<TypeCustomer> findAll() {
        return iTypeCustomerRepository.findAll();
    }

    @Override
    public TypeCustomer findById(int id) {
        return iTypeCustomerRepository.findById(id).orElse(null);
    }
}

package com.example.customer.service;

import com.example.customer.model.TypeCustomer;

import java.util.List;

public interface ITypeCustomerService {
    List<TypeCustomer> findAll();
    TypeCustomer findById(int id);
}

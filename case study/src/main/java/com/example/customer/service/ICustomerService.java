package com.example.customer.service;

import com.example.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void update(Customer customer);

    void delete(int id);

    void add (Customer customer);

    Optional<Customer> findById (int id);

    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
}

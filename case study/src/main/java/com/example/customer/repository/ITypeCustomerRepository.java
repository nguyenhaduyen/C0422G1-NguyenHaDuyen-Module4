package com.example.customer.repository;

import com.example.customer.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeCustomerRepository extends JpaRepository<TypeCustomer, Integer> {
}

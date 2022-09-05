package com.example.repository.impl;
import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private  static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Ha Bao","habao2210@gmail.com","DN"));
        customerList.add(new Customer(1,"Ha Duyen","haduyen2307@gmail.com","DN"));
        customerList.add(new Customer(1,"Ha Trinh","hatrinh1401@gmail.com","DN"));
        customerList.add(new Customer(1,"Ha Minh","haminh0808@gmail.com","DN"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}

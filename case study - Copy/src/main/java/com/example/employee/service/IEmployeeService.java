package com.example.employee.service;

import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface IEmployeeService {
    Page<Employee> findAllByNameOfEmployeeContaining(String name, Pageable pageable);

    void add(Employee employee);

    void delete(int id);

    void update(Employee employee);

    Employee findById(int id);
}

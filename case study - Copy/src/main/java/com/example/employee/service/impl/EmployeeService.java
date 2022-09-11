package com.example.employee.service.impl;

import com.example.employee.model.Employee;
import com.example.employee.repository.IEmployeeRepository;
import com.example.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllByNameOfEmployeeContaining(String name, Pageable pageable) {
        return iEmployeeRepository.findAllByNameOfEmployeeContaining(name, pageable);
    }

    @Override
    public void add(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }
}

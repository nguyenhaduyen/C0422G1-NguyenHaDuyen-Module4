package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByNameOfEmployeeContaining (String name, Pageable pageable);
}

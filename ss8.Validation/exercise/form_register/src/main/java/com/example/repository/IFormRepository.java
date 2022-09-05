package com.example.repository;

import com.example.model.Form;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormRepository extends JpaRepository<Form, Integer> {
    Page<Form> findAllByFirstNameContaining(String firstName, Pageable pageable);
}

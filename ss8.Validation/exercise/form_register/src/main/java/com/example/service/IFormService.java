package com.example.service;

import com.example.model.Form;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFormService {

    Page<Form> findAllByFirstNameContaining(String firstName, Pageable pageable);

    void create(Form form);
}

package com.example.service.impl;

import com.example.model.Form;
import com.example.repository.IFormRepository;
import com.example.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService {
    @Autowired
    private IFormRepository iFormRepository;


    @Override
    public Page<Form> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return iFormRepository.findAllByFirstNameContaining(firstName, pageable);
    }

    @Override
    public void create(Form form) {
        iFormRepository.save(form);
    }
}

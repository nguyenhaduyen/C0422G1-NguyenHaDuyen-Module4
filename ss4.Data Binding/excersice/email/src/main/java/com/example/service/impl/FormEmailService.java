package com.example.service.impl;

import com.example.model.FormEmail;
import com.example.repository.IFormEmailRepository;
import com.example.service.IFormEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormEmailService implements IFormEmailService {
    @Autowired
    private IFormEmailRepository iFormEmailRepository;

    @Override
    public void save(FormEmail formEmail) {
        iFormEmailRepository.save(formEmail);
    }

    @Override
    public FormEmail showEmail() {
        return iFormEmailRepository.showEmail();
    }
}

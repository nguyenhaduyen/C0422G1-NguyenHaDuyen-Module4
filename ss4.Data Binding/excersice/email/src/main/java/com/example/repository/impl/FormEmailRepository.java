package com.example.repository.impl;

import com.example.model.FormEmail;
import com.example.repository.IFormEmailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FormEmailRepository implements IFormEmailRepository {
    private FormEmail formEmailList;

    @Override
    public void save(FormEmail formEmail) {
        formEmailList = formEmail;
    }

    @Override
    public FormEmail showEmail() {
        return formEmailList;
    }
}

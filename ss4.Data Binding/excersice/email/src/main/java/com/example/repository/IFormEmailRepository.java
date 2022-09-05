package com.example.repository;

import com.example.model.FormEmail;

public interface IFormEmailRepository {
    void save(FormEmail formEmail);

    FormEmail showEmail();
}

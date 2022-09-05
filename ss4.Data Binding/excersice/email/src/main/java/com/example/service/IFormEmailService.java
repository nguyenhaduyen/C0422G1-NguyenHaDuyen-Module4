package com.example.service;

import com.example.model.FormEmail;

public interface IFormEmailService {
    void save(FormEmail formEmail);

    FormEmail showEmail();
}

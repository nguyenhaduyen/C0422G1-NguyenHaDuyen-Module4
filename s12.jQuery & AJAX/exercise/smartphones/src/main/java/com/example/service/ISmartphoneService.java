package com.example.service;

import com.example.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    void add(Smartphone smartphone);

    void update(Smartphone smartphone);

    Smartphone findById(int id);
}

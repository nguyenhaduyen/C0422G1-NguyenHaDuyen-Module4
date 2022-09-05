package com.example.service.impl;

import com.example.model.Smartphone;
import com.example.repository.ISmartphoneRepository;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public void add(Smartphone smartphone) {
        iSmartphoneRepository.save(smartphone);
    }

    @Override
    public void update(Smartphone smartphone) {
        iSmartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone findById(int id) {
        return iSmartphoneRepository.findById(id).orElse(null);
    }
}

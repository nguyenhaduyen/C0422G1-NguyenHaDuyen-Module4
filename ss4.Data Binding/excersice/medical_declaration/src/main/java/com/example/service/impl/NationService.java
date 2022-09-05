package com.example.service.impl;

import com.example.model.Nation;
import com.example.repository.INationRepository;
import com.example.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService implements INationService {
    @Autowired
    private INationRepository iNationRepository;

    @Override
    public List<Nation> findAll() {
        return iNationRepository.findAll();
    }
}

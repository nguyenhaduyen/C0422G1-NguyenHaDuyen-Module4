package com.example.service.impl;

import com.example.model.Condiment;
import com.example.repository.ICondimentRepository;
import com.example.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentService implements ICondimentService {
    @Autowired
    private ICondimentRepository iCondimentRepository;

    @Override
    public List<Condiment> findAll() {
        return iCondimentRepository.findAll();
    }
}

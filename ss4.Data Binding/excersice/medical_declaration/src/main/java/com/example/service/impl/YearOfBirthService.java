package com.example.service.impl;

import com.example.repository.IYearOfBirthRepository;
import com.example.service.IYearOfBirthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearOfBirthService implements IYearOfBirthService {
    @Autowired
    private IYearOfBirthRepository iYearOfBirthRepository;

    @Override
    public List<String> findAll() {
        return iYearOfBirthRepository.findAll();
    }
}

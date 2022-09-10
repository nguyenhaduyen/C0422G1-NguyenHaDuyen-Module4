package com.example.employee.service.impl;

import com.example.employee.model.Division;
import com.example.employee.repository.IDivisionRepository;
import com.example.employee.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}

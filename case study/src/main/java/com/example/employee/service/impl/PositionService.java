package com.example.employee.service.impl;

import com.example.employee.model.Position;
import com.example.employee.repository.IPositionRepository;
import com.example.employee.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}

package com.example.facility.service.impl;

import com.example.facility.model.RentType;
import com.example.facility.repository.IRentTypeRepository;
import com.example.facility.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}

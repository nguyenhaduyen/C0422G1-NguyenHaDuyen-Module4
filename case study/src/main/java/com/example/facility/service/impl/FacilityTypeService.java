package com.example.facility.service.impl;

import com.example.facility.model.FacilityType;
import com.example.facility.repository.IFacilityRepository;
import com.example.facility.repository.IFacilityTypeRepository;
import com.example.facility.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}

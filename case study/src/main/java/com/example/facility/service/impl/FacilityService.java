package com.example.facility.service.impl;

import com.example.facility.model.Facility;
import com.example.facility.repository.IFacilityRepository;
import com.example.facility.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void update(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void add(Facility facility) {
        if (facility.getFacilityType().getFacilityTypeId()==1) {
            facility.setFacilityFree(null);
        }
        if (facility.getFacilityType().getFacilityTypeId()==2) {
            facility.setPoolArea(null);
            facility.setFacilityFree(null);
        }
        if (facility.getFacilityType().getFacilityTypeId()==3) {
            facility.setStandardRoom(null);
            facility.setNumberOfFloor(null);
            facility.setPoolArea(null);
            facility.setDescriptionOtherConvenience(null);
        }
        iFacilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findId(int id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public Page<Facility> findAllByFacilityNameContaining(String name, Pageable pageable) {
        return iFacilityRepository.findAllByFacilityNameContaining(name, pageable);
    }

    @Override
    public void delete(int id) {
        iFacilityRepository.deleteById(id);
    }
}

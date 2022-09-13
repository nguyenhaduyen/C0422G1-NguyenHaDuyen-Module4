package com.example.contract.service.impl;

import com.example.contract.model.AttachFacility;
import com.example.contract.repository.IAttachFacilityRepository;
import com.example.contract.service.IAttachFacilityService;
import com.example.dto.AttachFacilityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> showAttachFacility(int id) {
        return iAttachFacilityRepository.showAttachFacility(id);
    }

    @Override
    public List<AttachFacilityDto> showQuantity(int id) {
        return iAttachFacilityRepository.showQuantity(id);
    }

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(int id) {
        return this.iAttachFacilityRepository.findById(id).orElse(null);
    }

}

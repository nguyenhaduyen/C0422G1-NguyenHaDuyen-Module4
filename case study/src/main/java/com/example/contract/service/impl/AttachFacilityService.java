package com.example.contract.service.impl;

import com.example.contract.model.AttachFacility;
import com.example.contract.repository.IAttachFacilityRepository;
import com.example.contract.service.IAttachFacilityService;
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
}

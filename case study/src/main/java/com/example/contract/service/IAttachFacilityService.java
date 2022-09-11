package com.example.contract.service;

import com.example.contract.model.AttachFacility;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> showAttachFacility(@Param("contract_id") int id);
}

package com.example.contract.service;

import com.example.contract.model.AttachFacility;
import com.example.dto.AttachFacilityDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> showAttachFacility(@Param("contract_id") int id);
    List<AttachFacilityDto> showQuantity(@Param("id") int id);
    List<AttachFacility> findAll();
    AttachFacility findById(int id);

}

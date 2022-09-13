package com.example.dto;

import javax.persistence.criteria.CriteriaBuilder;

public interface AttachFacilityDto {
    String getAttachFacilityName();
    Integer getAttachFacilityId();
    Double getPrice();
    String getStatus();
    String getUnit();
    Integer getQuantity();
}

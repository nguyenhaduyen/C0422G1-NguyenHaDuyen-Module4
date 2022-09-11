package com.example.facility.repository;

import com.example.customer.model.Customer;
import com.example.facility.model.Facility;
import com.example.facility.model.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
    Page<Facility> findAllByFacilityTypeNameContaining(String name, Pageable pageable);
}

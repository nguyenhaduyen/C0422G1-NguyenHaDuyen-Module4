package com.example.facility.repository;

import com.example.facility.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
//    Page<Facility> findAllByFacilityTypeNameContaining(String name, Pageable pageable);
}

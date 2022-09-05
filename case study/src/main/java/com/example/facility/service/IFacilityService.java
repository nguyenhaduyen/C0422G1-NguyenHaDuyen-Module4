package com.example.facility.service;

import com.example.facility.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<Facility> findAll();

    void update(Facility facility);

    void add(Facility facility);

    Optional<Facility> findId(int id);

//    Page<Facility> findAllByFacilityTypeNameContaining(String name, Pageable pageable);
}

package com.example.repository;

import com.example.model.Nation;

import java.util.List;

public interface INationRepository {
    List<Nation> findAll();
}

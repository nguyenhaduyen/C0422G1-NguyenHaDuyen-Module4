package com.example.repository;

import com.example.model.Condiment;

import java.util.List;

public interface ICondimentRepository {
    List<Condiment> findAll();
}

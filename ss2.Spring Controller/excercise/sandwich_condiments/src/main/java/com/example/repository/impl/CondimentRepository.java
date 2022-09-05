package com.example.repository.impl;

import com.example.model.Condiment;
import com.example.repository.ICondimentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentRepository implements ICondimentRepository {
    private static List<Condiment> condimentList = new ArrayList<>();

    static {
        condimentList.add(new Condiment("Lettuce"));
        condimentList.add(new Condiment("Tomato"));
        condimentList.add(new Condiment("Mustard"));
        condimentList.add(new Condiment("sprouts"));
    }

    @Override
    public List<Condiment> findAll() {
        return condimentList;
    }
}

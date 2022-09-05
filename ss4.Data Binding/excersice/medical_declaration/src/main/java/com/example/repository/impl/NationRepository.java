package com.example.repository.impl;

import com.example.model.Nation;
import com.example.repository.INationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NationRepository implements INationRepository {
    private static List<Nation> nationList = new ArrayList<>();

    static {
        nationList.add(new Nation("Viet Nam"));
        nationList.add(new Nation("Laos"));
        nationList.add(new Nation("Korea"));
        nationList.add(new Nation("America"));
    }

    @Override
    public List<Nation> findAll() {
        return nationList;
    }
}

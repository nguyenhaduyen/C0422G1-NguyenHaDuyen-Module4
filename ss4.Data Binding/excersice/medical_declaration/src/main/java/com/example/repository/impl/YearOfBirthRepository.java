package com.example.repository.impl;

import com.example.repository.IYearOfBirthRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class YearOfBirthRepository implements IYearOfBirthRepository {
    private static List<String> yearOfBirthList = new ArrayList<>();

    static {
        for (int i = 1940; i < LocalDate.now().getYear(); i++) {
            yearOfBirthList.add(i + "");
        }
    }

    @Override
    public List<String> findAll() {
        return yearOfBirthList;
    }
}

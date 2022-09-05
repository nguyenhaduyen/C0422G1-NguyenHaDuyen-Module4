package com.example.repository.impl;

import com.example.repository.IDateRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DateRepository implements IDateRepository {
    private static List<String> dateList = new ArrayList<>();
    private static List<String> monthList = new ArrayList<>();
    private static List<String> yearList = new ArrayList<>();

    static {
        for (int i = 1; i < 31; i++) {
            dateList.add(i + "");
        }
        for (int i = 1; i < 12; i++) {
            monthList.add(i + "");
        }
        for (int i = 2020; i < LocalDate.now().getYear(); i++) {
            yearList.add(i + "");
        }
    }

    @Override
    public List<String> findDateAll() {
        return dateList;
    }

    @Override
    public List<String> findMonthAll() {
        return monthList;
    }

    @Override
    public List<String> findYearAll() {
        return yearList;
    }
}

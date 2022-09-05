package com.example.repository;

import java.util.List;

public interface IDateRepository {
    List<String> findDateAll();

    List<String> findMonthAll();

    List<String> findYearAll();
}

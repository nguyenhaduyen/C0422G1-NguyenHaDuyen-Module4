package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    String[] arr1 = {"ant", "dog", "elephant"};
    String[] arr2 = {"con kien", "con cho", "con voi"};

    @Override
    public String search(String word) {

        String result = "khong tim thay";
        for (int i = 0; i < arr1.length; i++) {
            if (word.toLowerCase(Locale.ROOT).equals(arr1[i])) {
                result = arr2[i];
            }
        }
        return result;
    }
}

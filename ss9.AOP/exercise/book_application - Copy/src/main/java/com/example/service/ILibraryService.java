package com.example.service;

import com.example.model.Library;
import java.util.List;
import java.util.Optional;

public interface ILibraryService {
    List<Library> findAll();

    Optional<Library> findById(int id);

    void update(Library library);
}

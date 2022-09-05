package com.example.service.impl;

import com.example.model.Library;
import com.example.repository.ILibraryRepository;
import com.example.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LibraryService implements ILibraryService {
    @Autowired
    private ILibraryRepository iLibraryRepository;

    @Override
    public List<Library> findAll() {
        return iLibraryRepository.findAll();
    }

    @Override
    public Optional<Library> findById(int id) {
        return iLibraryRepository.findById(id);
    }

    @Override
    public void update(Library library) {
        iLibraryRepository.save(library);
    }
}

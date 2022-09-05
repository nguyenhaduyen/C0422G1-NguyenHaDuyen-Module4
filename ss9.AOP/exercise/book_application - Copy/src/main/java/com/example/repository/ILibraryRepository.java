package com.example.repository;

import com.example.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryRepository extends JpaRepository<Library, Integer> {
}

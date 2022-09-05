package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void update(Blog blog);

    void delete(int id);

    void save(Blog blog);

    Optional<Blog> findId(int id);

    Page<Blog> findAllByTittleContaining(String tittle, Pageable pageable);
}

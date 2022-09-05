package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void update(Blog blog);

    void delete(int id);

    void save(Blog blog);

    Optional<Blog> findId(int id);

    Page<Blog> findAllByCategoryBlog_NameOfCategoryContains(Pageable pageable,String name);

    Page<Blog> findAllByCategoryBlog_Id(Pageable pageable,int id);

    Page<Blog> findAllByTittleContaining(Pageable pageable,String name);

}

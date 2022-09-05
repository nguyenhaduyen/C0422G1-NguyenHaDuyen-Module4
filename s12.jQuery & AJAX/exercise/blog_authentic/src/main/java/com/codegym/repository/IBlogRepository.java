package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByCategoryBlog_NameOfCategoryContains(Pageable pageable,String name);
    Page<Blog> findAllByCategoryBlog_Id(Pageable pageable,int id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTittleContaining(Pageable pageable,String name);
}

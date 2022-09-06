package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findId(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public List<Blog> findAllByCategoryBlog_NameOfCategoryContains(String name) {
        return iBlogRepository.findAllByCategoryBlog_NameOfCategoryContains(name);
    }

    @Override
    public List<Blog> findAllByCategoryBlog_Id(int id) {
        return iBlogRepository.findAllByCategoryBlog_Id(id);
    }
}

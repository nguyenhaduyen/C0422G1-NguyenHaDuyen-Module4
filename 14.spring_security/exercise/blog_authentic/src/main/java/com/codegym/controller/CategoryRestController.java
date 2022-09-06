package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.CategoryBlog;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/categoryRest")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("/listCategory")
    public ResponseEntity<List<CategoryBlog>> listCategory () {
        List <CategoryBlog> categoryBlogs = iCategoryService.findAll();
        if (categoryBlogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryBlogs,HttpStatus.OK);
    }

}


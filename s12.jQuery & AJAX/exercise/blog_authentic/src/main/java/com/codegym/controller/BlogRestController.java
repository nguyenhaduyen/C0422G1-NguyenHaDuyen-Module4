package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping ("/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> listBlog (@PageableDefault (size = 5)Pageable pageable) {
        Page<Blog> blogList = iBlogService.findAll(pageable);
        if (!blogList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping ("/listBlogOfCategory")
    public ResponseEntity<Page<Blog>> listBlogOfCategory (@RequestParam int id,@PageableDefault (size = 5)Pageable pageable) {
        Page<Blog> blogList = iBlogService.findAllByCategoryBlog_Id(pageable,id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping ("/blogDetail")
    public ResponseEntity<Blog> blogDetail (@RequestParam int id) {
       Blog blog = iBlogService.findId(id).orElse(null);
       if (blog == null) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> listBlogFindByTittle (@PageableDefault Pageable pageable,@RequestParam String name) {
        Page<Blog> blogList = iBlogService.findAllByTittleContaining(pageable,name);
        if (!blogList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}

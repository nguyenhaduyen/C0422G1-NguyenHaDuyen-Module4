package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CategoryBlog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nameOfCategory;

    @OneToMany(mappedBy = "categoryBlog")
    private List<Blog> blogList;

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public CategoryBlog() {
    }

    public CategoryBlog(int id, String nameOfCategory) {
        this.id = id;
        this.nameOfCategory = nameOfCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }
}

package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tittle;
    private String content;
    private String authority;

    public Blog(int id, String tittle, String content, String authority) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.authority = authority;
    }

    public Blog(String tittle, String content, String authority) {
        this.tittle = tittle;
        this.content = content;
        this.authority = authority;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

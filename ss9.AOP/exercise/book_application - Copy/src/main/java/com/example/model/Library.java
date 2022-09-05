package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameOfBook;
    private int numberOfBook;
    private String author;
    private String category;
    private int status;

    public Library() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Library(int id, String nameOfBook, int numberOfBook, String author, String category, int status) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.numberOfBook = numberOfBook;
        this.author = author;
        this.category = category;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

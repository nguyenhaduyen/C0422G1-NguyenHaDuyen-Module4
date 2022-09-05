package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "library")
public class Library {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nameOfBook;
    private int numberOfBook;

    @OneToMany(mappedBy = "library")
    List<Book> bookList;

    public Library() {
    }

    public Library(int id, String nameOfBook, int numberOfBook, List<Book> bookList) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.numberOfBook = numberOfBook;
        this.bookList = bookList;
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}

package com.example.model;

import javax.persistence.*;

@Entity
@Table (name = "book")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nameOfBook;
    private String author;
    private String category;

    @ManyToOne
    @JoinColumn (name = "id_library", referencedColumnName = "id")
    private Library library;

    public Book(int id, String nameOfBook, String author, String category, Library library) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.author = author;
        this.category = category;
        this.library = library;
    }

    public Book() {
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}

package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String musician;
    private String category;

    public Music(int id, String name, String musician, String category) {
        this.id = id;
        this.name = name;
        this.musician = musician;
        this.category = category;
    }

    public Music(String name, String musician, String category) {
        this.name = name;
        this.musician = musician;
        this.category = category;
    }

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

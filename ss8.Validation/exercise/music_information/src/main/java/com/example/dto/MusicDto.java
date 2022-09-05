package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {
    private int id;
    @NotBlank
    @Size(min = 1, max = 800)
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Nhap dung dinh dang ten bai hat khong chua ki tu dac biet")
    private String name;
    @NotBlank
    @Size(min = 1, max = 300)
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Nhap dung dinh dang,ko co ki tu dac biet")
    private String musician;
    @NotBlank
    @Size(min = 1, max = 1000)
    @Pattern(regexp = "^[A-Za-z0-9, ]+$")
    private String category;

    public MusicDto() {
    }

    public MusicDto(String name, String musician, String category) {
        this.name = name;
        this.musician = musician;
        this.category = category;
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

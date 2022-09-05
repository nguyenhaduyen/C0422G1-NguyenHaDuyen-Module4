package com.example.model;

public class Language {
    private String nameOfLanguage;

    public Language(String nameOfLanguage) {
        this.nameOfLanguage = nameOfLanguage;
    }

    public String getNameOfLanguage() {
        return nameOfLanguage;
    }

    public void setNameOfLanguage(String nameOfLanguage) {
        this.nameOfLanguage = nameOfLanguage;
    }

    @Override
    public String toString() {
        return nameOfLanguage;
    }
}

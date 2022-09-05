package com.example.model;

public class Nation {
    private String nation;

    public Nation(String nation) {
        this.nation = nation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return nation;
    }
}

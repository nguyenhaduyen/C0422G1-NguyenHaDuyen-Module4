package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ten_san_pham")
    private String nameOfProduct;
    @Column(name = "gia")
    private double price;
    @Column(name = "mo_ta")
    private String description;
    @Column(name = "noi_san_xuat")
    private String madeIn;

    public Product() {

    }

    public Product(int id, String nameOfProduct, double price, String description, String madeIn) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.description = description;
        this.madeIn = madeIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
}

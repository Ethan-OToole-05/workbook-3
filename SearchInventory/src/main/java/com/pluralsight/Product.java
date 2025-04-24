package com.pluralsight;

public class Product {
    private int id;
    private String name;
    private float price;

    public Product() {
        this.id = 0;
        this.name = "";
        this.price = 0.0f;
    }
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}


package com.example.gamestop;

public class Popular {
    private String name;
    private int imageResId;
    private String price;

    public Popular(String name, int imageResId, String price) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getPrice() { return price; }
}   
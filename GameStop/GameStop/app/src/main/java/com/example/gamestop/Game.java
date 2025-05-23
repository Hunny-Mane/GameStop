package com.example.gamestop;

public class Game {
    private String name;
    private int imageResId;
    private String price;
    private String description;

    public Game(String name, int imageResId, String price, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
        this.description = description;
    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
}

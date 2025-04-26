package com.example.gamestop;

public class CartItem {
    public String title;
    public String price;
    public int imageResId;

    public CartItem(String title, String price, int imageResId) {
        this.title = title;
        this.price = price;
        this.imageResId = imageResId;
    }
}

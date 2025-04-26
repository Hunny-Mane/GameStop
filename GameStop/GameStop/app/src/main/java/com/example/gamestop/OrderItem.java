package com.example.gamestop;

public class OrderItem {
    public String gameTitle;
    public String orderId;
    public String price;
    public String status;
    public int imageResId;

    public OrderItem(String gameTitle, String orderId, String price, String status, int imageResId) {
        this.gameTitle = gameTitle;
        this.orderId = orderId;
        this.price = price;
        this.status = status;
        this.imageResId = imageResId;
    }
}

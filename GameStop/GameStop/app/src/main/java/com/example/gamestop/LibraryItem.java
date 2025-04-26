package com.example.gamestop;
public class LibraryItem {
    public String title;
    public boolean isInstalled;
    public int imageResId;

    public LibraryItem(String title, boolean isInstalled, int imageResId) {
        this.title = title;
        this.isInstalled = isInstalled;
        this.imageResId = imageResId;
    }
}

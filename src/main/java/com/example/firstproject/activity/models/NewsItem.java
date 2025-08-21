package com.example.firstproject.activity.models;

public class NewsItem {
    private String title;
    private int imageResId;

    public NewsItem(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }
    public String getTitle() { return title; }
    public int getImageResId() { return imageResId; }
}

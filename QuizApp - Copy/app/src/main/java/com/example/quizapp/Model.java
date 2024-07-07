package com.example.quizapp;

public class Model {
    private final String title;
    private final int imageResourceId;
    private final int id;

    public Model(String title, int imageResourceId, int id) {
        this.title = title;
        this.imageResourceId = imageResourceId;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getId() {
        return id;
    }
}


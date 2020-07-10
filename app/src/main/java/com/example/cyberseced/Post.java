package com.example.cyberseced;

import com.google.firebase.database.ServerValue;

public class Post {
    private String postKey;
    private String title;
    private String description;

    public Post(String postKey, String title, String description){
        this.title = title;
        this.description = description;
    }

    public Post() {
    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}

package com.example.anaraadmin;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class recipes implements Serializable
{

    @Exclude
    private String key;
    private String description;
    private String ingredients;
    private String username;
    public recipes(){}
    public recipes(String description, String ingredients, String username)
    {
        this.description = description;
        this.ingredients = ingredients;
        this.username = username;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}

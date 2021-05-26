package com.example.nimbbl.data.model.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CatalogModel implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("price")
    private String price;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

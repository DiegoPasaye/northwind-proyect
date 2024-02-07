package com.diego.northwindproyect.proyect.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
    
    @Id
    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "category_name")
    private String categoryName;


    @Column(name = "description")
    private String description;

    
    @Column(name = "picture")
    private String picture;


    public long getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }


    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }

    
}

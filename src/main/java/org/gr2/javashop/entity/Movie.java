package org.gr2.javashop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.net.URI;
import java.net.URL;
@Data
@Entity
public class Movie {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    @OneToOne
    private Category category;
    private double price;
    private int productionYear;
    private String description;
    private URI image;

    protected Movie() {
    }

    public Movie(String title, Category category, double price, int productionYear, String description, URI image) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.productionYear = productionYear;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getDescription() {
        return description;
    }

    public URI getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(URI image) {
        this.image = image;
    }
}

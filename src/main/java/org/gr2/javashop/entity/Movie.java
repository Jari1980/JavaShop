package org.gr2.javashop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

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
    private URL image;

    protected Movie() {
    }

    public Movie(String title, Category category, double price, int productionYear, String description, URL image) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.productionYear = productionYear;
        this.description = description;
        this.image = image;
    }
}

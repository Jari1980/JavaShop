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
}

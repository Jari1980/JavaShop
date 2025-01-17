package org.gr2.javashop.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.gr2.javashop.entity.Category;
import org.gr2.javashop.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.gr2.javashop.repository.CategoryRepository;
import org.gr2.javashop.repository.MovieRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Controller
public class MovieController {

    private MovieRepository movieRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }


    //This will be a button in admin pages to fill upp db to start later on
    @GetMapping("/seedCategories")
    public void seedCategories() {
        categoryRepository.save(new Category("Action"));
        categoryRepository.save(new Category("Drama"));
        categoryRepository.save(new Category("SciFi"));
        categoryRepository.save(new Category("Fantasy"));
        categoryRepository.save(new Category("Broccoli"));
    }

    //This will be a button in admin pages to fill upp db to start later on
    @GetMapping("/seedMovies")
    public void seedMovies() {
        try{
            movieRepository.save(new Movie("Spider Girl", categoryRepository.findById(1).get(), 199.99, 1955, "Awesome action movie", getClass().getClassLoader().getResource("static/images/Broccoli.jpg")));
            movieRepository.save(new Movie("Broccoli Superstar", categoryRepository.findById(2).get(), 299.99, 1980, "Fantastic movie", getClass().getClassLoader().getResource("static/images/Broccoli.jpg")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

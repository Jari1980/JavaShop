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

@Controller
public class MovieController {

    private MovieRepository movieRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    /*
    @PostMapping("/seedCategory")
    public void seedCategory(){
        categoryRepository.seed();
    }
     */

    @GetMapping("/seedCategories")
    public void seedCategories() {
        categoryRepository.save(new Category("Action"));
        categoryRepository.save(new Category("Drama"));
        categoryRepository.save(new Category("SciFi"));
        categoryRepository.save(new Category("Fantasy"));
        categoryRepository.save(new Category("Broccoli"));

    }

}

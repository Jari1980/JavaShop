package org.gr2.javashop.controller;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.gr2.javashop.entity.Category;
import org.gr2.javashop.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.gr2.javashop.repository.CategoryRepository;
import org.gr2.javashop.repository.MovieRepository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

@Controller
public class MovieController {

    private MovieRepository movieRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String homepage(HttpSession session) {

        try {
            List<Movie> latest3Movies = ((List<Movie>) movieRepository.findAll()).stream().limit(3).toList();
            session.setAttribute("latest3Movies", latest3Movies);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage() + ", didnt get last three movies");
        }

        return "index";
    }

    @PostMapping("/")
    public String homepage(@RequestParam(value = "searchValue") String searchValue, HttpSession session) {
        try{
            List<Movie> allMovies = (List<Movie>) movieRepository.findAll();
            List<Movie> movieRes = allMovies.stream().filter(m -> m.getTitle().toLowerCase().contains(searchValue.toLowerCase())).collect(Collectors.toList());
            session.setAttribute("movieRes", movieRes);
            List<Movie> latest3Movies = ((List<Movie>) movieRepository.findAll()).stream().limit(3).toList();
            session.setAttribute("latest3Movies", latest3Movies);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage() + ", Search function didnt work...............");
        }
        return "index";
    }



    @GetMapping("/categories")
    public void categories(){

    }

    @GetMapping("/allMovies")
    public void allMovies(){

    }

    @GetMapping("/adminPages")
    public void adminPages(HttpSession session){
        if(movieRepository.count() < 1){
            session.setAttribute("showSeed", true);
        }
        else session.setAttribute("showSeed", false);
    }

    @PostMapping(value = "/adminPages")
    public void adminPages(@RequestParam(name = "seed") String seed, HttpSession session) {

        categoryRepository.save(new Category("Action"));
        categoryRepository.save(new Category("Drama"));
        categoryRepository.save(new Category("SciFi"));
        categoryRepository.save(new Category("Fantasy"));
        categoryRepository.save(new Category("Broccoli"));

        try{
            movieRepository.save(new Movie("Spider Girl", categoryRepository.findById(1).get(), 199.99, 1955, "Awesome action movie", new URI("images/SpiderGirl.jpg")));
            movieRepository.save(new Movie("Broccoli Superstar", categoryRepository.findById(2).get(), 299.99, 1980, "Fantastic movie", new URI("images/Broccoli.jpg")));
            movieRepository.save(new Movie("Java Warrior", categoryRepository.findById(3).get(), 99.99, 1980, "Java warrior go bananas", new URI("images/JavaWarrior.jpg")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(movieRepository.count() < 1){
            session.setAttribute("showSeed", true);
        }
        else session.setAttribute("showSeed", false);

    }



    @GetMapping("/about")
    public void about(){

    }

    /*
    @GetMapping("/seedCategories")
    public void seedCategories() {
        categoryRepository.save(new Category("Action"));
        categoryRepository.save(new Category("Drama"));
        categoryRepository.save(new Category("SciFi"));
        categoryRepository.save(new Category("Fantasy"));
        categoryRepository.save(new Category("Broccoli"));

    }


    @GetMapping("/seedMovies")
    public void seedMovies() {
        try{
            movieRepository.save(new Movie("Spider Girl", categoryRepository.findById(1).get(), 199.99, 1955, "Awesome action movie", new URI("images/SpiderGirl.jpg")));
            movieRepository.save(new Movie("Broccoli Superstar", categoryRepository.findById(2).get(), 299.99, 1980, "Fantastic movie", new URI("images/Broccoli.jpg")));
            movieRepository.save(new Movie("Java Warrior", categoryRepository.findById(3).get(), 99.99, 1980, "Java warrior go bananas", new URI("images/JavaWarrior.jpg")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

     */

    @GetMapping("/layout")
    public void layout(){

    }



}

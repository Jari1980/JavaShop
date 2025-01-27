package org.gr2.javashop.repository;

import org.gr2.javashop.entity.Category;
import org.gr2.javashop.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByCategory(Category category);
}

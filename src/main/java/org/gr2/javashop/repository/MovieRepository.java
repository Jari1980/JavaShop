package org.gr2.javashop.repository;

import org.gr2.javashop.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {


    static void seed() {
        Movie movie1 = new Movie();

    }
}

package org.gr2.javashop.repository;

import org.gr2.javashop.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    default void seed() {
        Category c1 = new Category();
        c1.setName("Action");
        Category c2 = new Category();
        c2.setName("Drama");
        Category c3 = new Category();
        c3.setName("SciFi");
        Category c4 = new Category();
        c4.setName("Fantasy");
        Category c5 = new Category();
        c5.setName("Broccoli");
    }
}

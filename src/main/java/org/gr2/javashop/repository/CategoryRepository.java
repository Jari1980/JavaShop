package org.gr2.javashop.repository;

import jakarta.transaction.Transactional;
import org.gr2.javashop.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByName(String name);
}

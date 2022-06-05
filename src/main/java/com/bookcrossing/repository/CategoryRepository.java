package com.bookcrossing.repository;

import com.bookcrossing.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    CategoryModel findByName(String name);
}

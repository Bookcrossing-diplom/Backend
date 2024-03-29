package com.bookcrossing.repository;

import com.bookcrossing.model.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Long> {
    GenreModel findByName(String name);
}

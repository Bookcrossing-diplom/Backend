package com.bookcrossing.repository;

import com.bookcrossing.model.BookUserRatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserRatingRepository extends JpaRepository<BookUserRatingModel, Long> {
}

package com.bookcrossing.repository;

import com.bookcrossing.model.BookUserCommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserCommentRepository extends JpaRepository<BookUserCommentModel, Long> {
}

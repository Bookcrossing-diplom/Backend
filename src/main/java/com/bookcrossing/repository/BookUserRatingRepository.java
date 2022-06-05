package com.bookcrossing.repository;

import com.bookcrossing.model.BookUserRatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BookUserRatingRepository extends JpaRepository<BookUserRatingModel, Long> {

    BookUserRatingModel findByUsersModelIdAndBookModelId(long userId, long bookId);

    @Modifying
    @Query("update BookUserRatingModel bur set bur.grade = ?3 where bur.usersModel.id = ?1 and bur.bookModel.id = ?2")
    void updateRating(long userId, long bookId, int grade);
}

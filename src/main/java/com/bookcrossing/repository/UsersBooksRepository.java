package com.bookcrossing.repository;

import com.bookcrossing.model.UsersBooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsersBooksRepository extends JpaRepository<UsersBooksModel, Long> {
    @Modifying
    @Query("delete from UsersBooksModel where usersModel.id = ?1 and bookModel.id = ?2 and type= 'Мои'")
    void deleteUsersBook(long user_id, long book_id);

    @Modifying
    @Query("delete from UsersBooksModel where usersModel.id = ?1 and bookModel.id = ?2 and type= 'Желаемые'")
    void deleteUsersDesiredBook(long userId, long bookId);
}

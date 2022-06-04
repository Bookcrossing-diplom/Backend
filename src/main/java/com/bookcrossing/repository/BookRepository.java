package com.bookcrossing.repository;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.model.BookModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

    @Query("select b from BookModel b " +
            "inner join UsersBooksModel ub on b.id = ub.bookModel.id " +
            "inner join UsersModel u on u.id = ub.usersModel.id " +
            "where ub.type = 'Мои' and u.id = ?1")
    List<BookModel> findAllUsersBooks(long id);

    @Query("select b from BookModel b " +
            "inner join UsersBooksModel ub on b.id = ub.bookModel.id " +
            "inner join UsersModel u on u.id = ub.usersModel.id " +
            "where ub.type = 'Желаемые' and u.id = ?1")
    List<BookModel> findAllUsersDesiredBooks(long id);
}

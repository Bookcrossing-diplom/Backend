package com.bookcrossing.repository;

import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    UsersModel findByLogin(String login);

    boolean existsByLogin(String login);
    boolean existsByEmail(String email);

    @Query("select u from UsersModel u where u.id = ?1")
    UsersPersonalOfficeInfo findById(long id);

    @Modifying
    @Query("update UsersModel u set u.firstname = ?2 where u.id = ?1")
    void updateFirstname(long id, String firstname);

    @Modifying
    @Query("update UsersModel u set u.lastname = ?2 where u.id = ?1")
    void updateLastname(long id, String lastname);

    @Modifying
    @Query("update UsersModel u set u.city = ?2 where u.id = ?1")
    void updateCity(long id, String city);

    @Query("select b from BookModel b" +
            " inner join UsersBooksModel ub on b.id = ub.bookModel.id and ub.type='Мои'" +
            " inner join UsersModel u on ub.usersModel.id = u.id and u.id = ?1")
    List<BookModel> findMyBook(long id);

    @Query("select b from BookModel b" +
            " inner join UsersBooksModel ub on b.id = ub.bookModel.id and ub.type='Желаемые'" +
            " inner join UsersModel u on ub.usersModel.id = u.id and u.id = ?1")
    List<BookModel> findDesiredUsersBook(long id);


}

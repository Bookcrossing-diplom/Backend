package com.bookcrossing.repository;

import com.bookcrossing.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    //auth & reg user
    UsersModel findByLogin(String login);
    boolean existsByLogin(String login);
    boolean existsByEmail(String email);

    @Query("select u from UsersModel u where u.id = ?1")
    UsersModel findById(long id);

    //update user
    @Modifying
    @Query("update UsersModel u set u.firstname = ?2 where u.id = ?1")
    void updateFirstname(long id, String firstname);

    @Modifying
    @Query("update UsersModel u set u.lastname = ?2 where u.id = ?1")
    void updateLastname(long id, String lastname);

    @Modifying
    @Query("update UsersModel u set u.city = ?2 where u.id = ?1")
    void updateCity(long id, String city);

    @Modifying
    @Query("update UsersModel u set u.email = ?2 where u.id = ?1")
    void updateEmail(long id, String email);

    /*
    надо чуть подумать потому что не работает
    @Modifying
    @Query("update UsersModel u set u.categories = ?2 where u.id = ?1")
    void updateCategory(long id, Set<CategoryModel> categories);
     */
}

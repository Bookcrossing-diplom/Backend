package com.bookcrossing.repository;

import com.bookcrossing.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE u.email = ?1")
    UserModel findByEmail(String email);
    UserModel findById(long id);

}

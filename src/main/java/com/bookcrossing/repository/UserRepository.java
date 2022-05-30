package com.bookcrossing.repository;

import com.bookcrossing.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersModel, Long> {
}

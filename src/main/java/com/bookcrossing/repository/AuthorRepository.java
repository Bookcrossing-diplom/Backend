package com.bookcrossing.repository;

import com.bookcrossing.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {

    AuthorModel findByFirstnameAndLastname(String firstname, String lastname);
}

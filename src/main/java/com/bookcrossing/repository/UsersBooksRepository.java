package com.bookcrossing.repository;

import com.bookcrossing.model.UsersBooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersBooksRepository extends JpaRepository<UsersBooksModel, Long> {
}

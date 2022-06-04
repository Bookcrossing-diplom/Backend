package com.bookcrossing.repository;

import com.bookcrossing.model.NewsFeedModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsFeedRepository extends JpaRepository<NewsFeedModel, Long> {
}

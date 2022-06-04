package com.bookcrossing.service;

import com.bookcrossing.model.NewsFeedModel;

import java.util.List;

public interface NewsFeedService {
    List<NewsFeedModel> findAllNewsFeed();
}

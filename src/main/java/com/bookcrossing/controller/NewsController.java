package com.bookcrossing.controller;

import com.bookcrossing.model.NewsFeedModel;
import com.bookcrossing.service.impl.NewsFeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsFeedServiceImpl newsFeedService;

    @GetMapping("/news")
    public ResponseEntity<List<NewsFeedModel>> findAllNewsFeed(){
        return ResponseEntity.ok().body(newsFeedService.findAllNewsFeed());
    }
}

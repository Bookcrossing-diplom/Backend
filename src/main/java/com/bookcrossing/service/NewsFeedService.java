package com.bookcrossing.service;

import com.bookcrossing.model.NewsFeedModel;
import com.bookcrossing.repository.NewsFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsFeedService {
    @Autowired
    NewsFeedRepository newsFeedRepository;


    public List<NewsFeedModel> findAllNewsFeed() {
        List<NewsFeedModel> newsFeedModels = newsFeedRepository.findAll().stream().sorted(Comparator.comparing(NewsFeedModel::getDateOfPosting).reversed()).collect(Collectors.toList());
        return newsFeedModels;
    }
}

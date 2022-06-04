package com.bookcrossing.service;

import com.bookcrossing.model.AuthorModel;

import java.util.List;

public interface AuthorService {
    List<AuthorModel> findAll();
}

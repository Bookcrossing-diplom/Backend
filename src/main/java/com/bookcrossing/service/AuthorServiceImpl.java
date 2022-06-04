package com.bookcrossing.service;

import com.bookcrossing.model.AuthorModel;
import com.bookcrossing.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl {
    @Autowired
    AuthorRepository authorRepository;

    public List<AuthorModel> findAll() {
        return authorRepository.findAll();
    }
}

package com.bookcrossing.service.impl;

import com.bookcrossing.model.AuthorModel;
import com.bookcrossing.repository.AuthorRepository;
import com.bookcrossing.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<AuthorModel> findAll() {
        return authorRepository.findAll();
    }
}

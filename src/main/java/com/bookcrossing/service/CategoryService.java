package com.bookcrossing.service;

import com.bookcrossing.model.CategoryModel;
import com.bookcrossing.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public List<CategoryModel> findAllCategoryWithGenre() {
        return categoryRepository.findAll();
    }
}

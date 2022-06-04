package com.bookcrossing.service.impl;

import com.bookcrossing.model.CategoryModel;
import com.bookcrossing.repository.CategoryRepository;
import com.bookcrossing.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public List<CategoryModel> findAllCategoryWithGenre() {
        return categoryRepository.findAll();
    }
}

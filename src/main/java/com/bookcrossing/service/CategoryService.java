package com.bookcrossing.service;

import com.bookcrossing.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> findAllCategoryWithGenre();
}

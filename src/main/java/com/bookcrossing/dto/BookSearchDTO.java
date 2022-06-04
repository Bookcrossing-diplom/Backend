package com.bookcrossing.dto;

import com.bookcrossing.model.BookUserRatingModel;
import com.bookcrossing.model.GenreModel;

import java.util.List;
import java.util.Set;

public class BookSearchDTO {
    private long id;

    private String name;

    private String edition;

    private String yearPublishing;

    private Set<AuthorDTO> authors;

    private Set<CategoryDTO> categories;

    private Set<GenreModel> genres;

    private List<BookUserRatingModel> bookUserRatings;
}

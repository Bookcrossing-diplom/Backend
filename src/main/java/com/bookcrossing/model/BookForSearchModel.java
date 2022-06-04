package com.bookcrossing.model;

import com.bookcrossing.dto.AuthorDTO;
import com.bookcrossing.dto.CategoryDTO;
import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class BookForSearchModel {

    private long id;

    private String name;

    private String edition;

    private String yearPublishing;

    private Set<AuthorModel> authors;

    private Set<CategoryModel> categories;

    private Set<GenreModel> genres;

    private double rating;

}

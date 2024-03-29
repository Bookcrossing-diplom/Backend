package com.bookcrossing.dto;

import com.bookcrossing.model.BookUserCommentModel;
import com.bookcrossing.model.GenreModel;
import com.bookcrossing.model.UsersBooksModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class BookPageDTO{

    private long id;

    private String name;

    private String edition;

    private String yearPublishing;

    private Set<AuthorDTO> authors;

    private Set<CategoryDTO> categories;

    private Set<GenreModel> genres;

    private double rating;

    private List<BookUserCommentDTO> bookUserCommentModels;

    private List<BooksUsersDTO> usersBooks;

}

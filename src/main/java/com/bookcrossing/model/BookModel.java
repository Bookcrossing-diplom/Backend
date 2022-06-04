package com.bookcrossing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "book")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "edition",length = 50, nullable = false)
    private String edition;

    @Column(name = "year_publishing",length = 50, nullable = false)
    private String yearPublishing;

    @JsonIgnore
    @OneToMany(mappedBy = "bookModel", cascade = CascadeType.ALL)
    private List<UsersBooksModel> usersBooks;

    @OneToMany(mappedBy = "bookModel", cascade = CascadeType.ALL)
    private List<BookUserRatingModel> bookUserRatings;

    @OneToMany(mappedBy = "bookModel", cascade = CascadeType.ALL)
    private List<BookUserCommentModel> bookUserCommentModels;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorModel> authors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryModel> categories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<GenreModel> genres;
}

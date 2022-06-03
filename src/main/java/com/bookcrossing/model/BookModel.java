package com.bookcrossing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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
    private List<UsersBooksModel> usersBooks = new LinkedList<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorModel> authors = new HashSet<>();

//    public void addAuthor(AuthorModel authorModel){
//        this.authors.add(authorModel);
//        authorModel.getBooks().add(this);
//    }
//
//    public void removeAuthor(AuthorModel authorModel){
//        this.authors.remove(authorModel);
//        authorModel.getBooks().remove(this);
//    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryModel> categories = new HashSet<>();

//    public void addCategory(CategoryModel categoryModel){
//        this.categories.add(categoryModel);
//        categoryModel.getBooks().add(this);
//    }
//    public void removeAuthor(CategoryModel categoryModel){
//        this.categories.remove(categoryModel);
//        categoryModel.getBooks().remove(this);
//    }


}

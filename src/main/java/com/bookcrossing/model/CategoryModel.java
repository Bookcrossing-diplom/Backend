package com.bookcrossing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50,nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private Set<BookModel> books;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private Set<UsersModel> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_genre",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<GenreModel> genres;

}

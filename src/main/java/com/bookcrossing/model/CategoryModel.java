package com.bookcrossing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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
    private Set<BookModel> books = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_genre",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<GenreModel> genres = new HashSet<>();

    public void addCategory(GenreModel genreModel){
        this.genres.add(genreModel);
        genreModel.getCategories().add(this);
    }
    public void removeAuthor(GenreModel genreModel){
        this.genres.remove(genreModel);
        genreModel.getCategories().remove(this);
    }
}

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
@Table(name = "genre")
public class GenreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50,nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "genres")
    private Set<CategoryModel> categories = new HashSet<>();
}

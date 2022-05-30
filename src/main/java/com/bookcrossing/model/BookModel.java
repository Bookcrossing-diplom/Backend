package com.bookcrossing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private List<UsersBooksModel> usersBooks;

}

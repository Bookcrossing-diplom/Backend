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
@Table(name = "users")
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login",length = 50,unique = true, nullable = false)
    private String login;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "firstname", length = 50,nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "usersModel", cascade = CascadeType.ALL)
    private List<UsersBooksModel> usersBooks;

    @OneToMany(mappedBy = "usersModel", cascade = CascadeType.ALL)
    private List<BookUserRatingModel> bookUserRatings;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_category",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryModel> categories;

}


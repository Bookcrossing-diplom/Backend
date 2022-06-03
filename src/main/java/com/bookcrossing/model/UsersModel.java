package com.bookcrossing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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

}


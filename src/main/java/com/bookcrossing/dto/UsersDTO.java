package com.bookcrossing.dto;

import com.bookcrossing.model.UsersBooksModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UsersDTO {
    private long id;

    private String login;

    private String firstname;

    private String lastname;

    private String email;

    private String city;

    private Set<CategoryDTO> categories;

    private List<UsersBooksDTO> usersBooks;

}

package com.bookcrossing.dto;

import com.bookcrossing.model.CategoryModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
}

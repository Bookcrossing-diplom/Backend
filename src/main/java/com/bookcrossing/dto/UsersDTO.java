package com.bookcrossing.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {
    private long id;

    private String login;

    private String firstname;

    private String lastname;

    private String email;

    private String city;
}

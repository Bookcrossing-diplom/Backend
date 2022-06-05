package com.bookcrossing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersNameDTO {

    private long id;

    private String login;

    private String firstname;

    private String lastname;
}

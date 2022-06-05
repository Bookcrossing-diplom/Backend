package com.bookcrossing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUserCommentDTO {
    private long id;
    private UsersNameDTO usersModel;
    private String comment;

}

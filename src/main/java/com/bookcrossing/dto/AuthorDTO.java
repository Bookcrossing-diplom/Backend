package com.bookcrossing.dto;

import com.bookcrossing.model.BookModel;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorDTO {

    private long id;

    private String firstname;

    private String lastname;

}

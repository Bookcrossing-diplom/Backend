package com.bookcrossing.dto;

import com.bookcrossing.model.BookModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorDTO {

    private long id;

    private String firstname;

    private String lastname;



}

package com.bookcrossing.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BookDTO {

    private long id;

    private String name;

    private String edition;

    private String yearPublishing;

    private Set<AuthorDTO> authors;
}

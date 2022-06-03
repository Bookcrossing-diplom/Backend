package com.bookcrossing.dto;

import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {

    private long id;

    private String name;

    private String edition;

    private String yearPublishing;

    private Set<AuthorDTO> authors;
}

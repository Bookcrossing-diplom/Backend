package com.bookcrossing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BookNameDTO {

    private long id;

    private String name;

    private Set<AuthorDTO> authors;
}

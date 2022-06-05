package com.bookcrossing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersBooksDTO {

    private long id;
    private BookNameDTO bookModel;
    private String type;
}

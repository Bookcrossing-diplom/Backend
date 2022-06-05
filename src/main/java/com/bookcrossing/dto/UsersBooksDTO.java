package com.bookcrossing.dto;

import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersBooksDTO {

    private long id;
    private BookNameDTO bookModel;
    private String type;
}

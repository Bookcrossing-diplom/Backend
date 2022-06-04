package com.bookcrossing.service;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;


import java.util.List;

public interface UsersService {
    UsersDTO findById(long id);

    UsersDTO updateInfo(UsersModel usersModel);

    List<BookDTO> findMyBook(long id);

    List<BookDTO> saveMyBook(long id, BookModel bookModel);

//    List<BookDTO> findDesiredUsersBook(long id);

    List<BookDTO> saveDesiredBook(long id, BookModel bookModel);

}

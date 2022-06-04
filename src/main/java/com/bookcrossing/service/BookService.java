package com.bookcrossing.service;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.model.BookModel;

import java.util.List;

public interface BookService {
    List<BookDTO> findMyBook(long id);

    List<BookDTO> saveMyBook(long id, BookModel bookModel);

    List<BookDTO> deleteUsersBook(long userId, long bookId);

    List<BookDTO> findUsersDesiredBook(long id);

    List<BookDTO> saveDesiredBook(long id, BookModel bookModel);

    List<BookDTO> deleteUsersDesiredBook(long userId, long bookId);
}

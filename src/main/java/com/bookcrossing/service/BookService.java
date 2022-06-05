package com.bookcrossing.service;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.model.BookModel;

import java.util.List;

public interface BookService {
    List<BookDTO> findByBookName(String bookName);

    List<BookDTO> findUserBooks(long userId);

    List<BookDTO> saveUserBook(long userId, BookModel bookModel);

    List<BookDTO> deleteUserBook(long userId, long bookId);

    List<BookDTO> findUserDesiredBook(long userId);

    List<BookDTO> saveDesiredBook(long userId, BookModel bookModel);

    List<BookDTO> deleteUserDesiredBook(long userId, long bookId);
}

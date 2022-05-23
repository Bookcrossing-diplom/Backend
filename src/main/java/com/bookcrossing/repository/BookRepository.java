package com.bookcrossing.repository;


import com.bookcrossing.model.BookModel;

import java.util.List;

public interface BookRepository {

    List<BookModel> getAllBook(Long id);
}

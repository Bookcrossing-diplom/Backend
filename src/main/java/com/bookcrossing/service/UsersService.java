package com.bookcrossing.service;

import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.UsersPersonalOfficeInfo;

import java.util.List;

public interface UsersService {
    UsersPersonalOfficeInfo findById(long id);

    UsersPersonalOfficeInfo updateInfo(UsersModel usersModel);

    List<BookModel> findMyBook(long id);

    List<BookModel> findDesiredUsersBook(long id);

    List<BookModel> updateMyBook(long id, BookModel bookModel);

    List<BookModel> updateDesiredUsersBook(long id, BookModel bookModel);

}

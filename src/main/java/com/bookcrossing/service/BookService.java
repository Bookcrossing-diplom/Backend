package com.bookcrossing.service;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.mapper.BookMapper;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersBooksModel;
import com.bookcrossing.repository.BookRepository;
import com.bookcrossing.repository.UsersBooksRepository;
import com.bookcrossing.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersBooksRepository usersBooksRepository;

    public List<BookDTO> findMyBook(long id) {
        return BookMapper.BOOK_MAPPER.bookModelToBookDTO(bookRepository.findAllUsersBooks(id));
    }

    public List<BookDTO> saveMyBook(long id, BookModel bookModel) {

        bookRepository.save(bookModel);
        usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(id)).bookModel(bookModel).type("Мои").build());
        return findMyBook(id);
    }

    public List<BookDTO> deleteUsersBook(long userId, long bookId) {
        usersBooksRepository.deleteUsersBook(userId, bookId);
        return findMyBook(userId);
    }


    public List<BookDTO> findUsersDesiredBook(long id) {
        return BookMapper.BOOK_MAPPER.bookModelToBookDTO(bookRepository.findAllUsersDesiredBooks(id));
    }

    public List<BookDTO> saveDesiredBook(long id, BookModel bookModel) {

        bookRepository.save(bookModel);
        usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(id)).bookModel(bookModel).type("Желаемые").build());
        return findUsersDesiredBook(id);
    }

    public List<BookDTO> deleteUsersDesiredBook(long userId, long bookId) {
        usersBooksRepository.deleteUsersDesiredBook(userId, bookId);
        return findUsersDesiredBook(userId);
    }
}

package com.bookcrossing.service.impl;

import com.bookcrossing.dto.AuthorDTO;
import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.mapper.BookMapper;
import com.bookcrossing.model.*;
import com.bookcrossing.repository.BookRepository;
import com.bookcrossing.repository.BookUserCommentRepository;
import com.bookcrossing.repository.UsersBooksRepository;
import com.bookcrossing.repository.UsersRepository;
import com.bookcrossing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersBooksRepository usersBooksRepository;

    @Autowired
    BookUserCommentRepository bookUserCommentRepository;

    public List<BookForSearchModel> findAll() {
        List<BookModel> bookModels = bookRepository.findAll();
        ArrayList<BookForSearchModel> bookForSearchModels = new ArrayList<>();
        double tmp = 0;

        for(BookModel bookModel: bookModels){
            List<BookUserRatingModel> a = bookModel.getBookUserRatings();
            for (BookUserRatingModel bookUserRatingModel : a){
                tmp += bookUserRatingModel.getGrade();
            }

            bookForSearchModels.add(BookForSearchModel.builder().
                    id(bookModel.getId()).
                    name(bookModel.getName()).
                    edition(bookModel.getEdition()).
                    yearPublishing(bookModel.getYearPublishing()).
                    authors(bookModel.getAuthors()).
                    categories(bookModel.getCategories()).
                    genres(bookModel.getGenres()).
                    rating(
                            tmp/bookModel.getBookUserRatings().stream().count()
                    ).
                    bookUserCommentModels(bookModel.getBookUserCommentModels()).
                    build()

            );
            tmp = 0;
        }
        return bookForSearchModels;
    }

    public BookForSearchModel findBook(long bookId) {
        BookModel bookModel = bookRepository.getById(bookId);
        double tmp = 0;
        List<BookUserRatingModel> a = bookModel.getBookUserRatings();
        for (BookUserRatingModel bookUserRatingModel : a){
            tmp += bookUserRatingModel.getGrade();
        }

        return BookForSearchModel.builder().
                id(bookModel.getId()).
                name(bookModel.getName()).
                edition(bookModel.getEdition()).
                yearPublishing(bookModel.getYearPublishing()).
                authors(bookModel.getAuthors()).
                categories(bookModel.getCategories()).
                genres(bookModel.getGenres()).
                rating(
                        tmp/bookModel.getBookUserRatings().stream().count()
                ).
                bookUserCommentModels(bookModel.getBookUserCommentModels()).
                build();
    }

    public BookForSearchModel addComent(long bookId, long userId, String comment) {
        bookUserCommentRepository.save(BookUserCommentModel.builder().
                bookModel(bookRepository.getById(bookId)).
                usersModel(usersRepository.findById(userId)).
                comment(comment).
                build());
        BookModel bookModel = bookRepository.getById(bookId);
        double tmp = 0;
        List<BookUserRatingModel> a = bookModel.getBookUserRatings();
        for (BookUserRatingModel bookUserRatingModel : a){
            tmp += bookUserRatingModel.getGrade();
        }

        return BookForSearchModel.builder().
                id(bookModel.getId()).
                name(bookModel.getName()).
                edition(bookModel.getEdition()).
                yearPublishing(bookModel.getYearPublishing()).
                authors(bookModel.getAuthors()).
                categories(bookModel.getCategories()).
                genres(bookModel.getGenres()).
                rating(
                        tmp/bookModel.getBookUserRatings().stream().count()
                ).
                bookUserCommentModels(bookModel.getBookUserCommentModels()).
                build();
    }

    public List<BookDTO> findByBookName(String bookName) {
        return BookMapper.BOOK_MAPPER.bookModelToBookDTO(bookRepository.findByNameContaining(bookName));
    }

    public List<BookDTO> findMyBook(long id) {
        return BookMapper.BOOK_MAPPER.bookModelToBookDTO(bookRepository.findAllUsersBooks(id));
    }

    public List<BookDTO> saveMyBook(long id, BookModel bookModel) {
        if (bookModel.getId() != 0){
            usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(id)).bookModel(bookRepository.getById(bookModel.getId())).type("Мои").build());
        }else{
            bookRepository.save(bookModel);
            usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(id)).bookModel(bookModel).type("Мои").build());
        }
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
        if (bookModel.getId() != 0){
            usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(id)).bookModel(bookRepository.getById(bookModel.getId())).type("Желаемые").build());
        }else{

        bookRepository.save(bookModel);
        usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(id)).bookModel(bookModel).type("Желаемые").build());}
        return findUsersDesiredBook(id);
    }

    public List<BookDTO> deleteUsersDesiredBook(long userId, long bookId) {
        usersBooksRepository.deleteUsersDesiredBook(userId, bookId);
        return findUsersDesiredBook(userId);
    }


}

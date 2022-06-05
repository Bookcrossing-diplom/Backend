package com.bookcrossing.service.impl;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.BookPageDTO;
import com.bookcrossing.mapper.BookMapper;
import com.bookcrossing.model.*;
import com.bookcrossing.repository.*;
import com.bookcrossing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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

    @Autowired
    BookUserRatingRepository bookUserRatingRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GenreRepository genreRepository;

    public List<BookDTO> findUserBooks(long userId) {
        return BookMapper.BOOK_MAPPER.bookModelsToBookDTOs(bookRepository.findAllUsersBooks(userId));
    }

    public List<BookDTO> saveUserBook(long userId, BookModel bookModel) {
        if (bookModel.getId() != 0){
            usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(userId)).bookModel(bookRepository.getById(bookModel.getId())).type("Мои").build());
        }else{
            createNewBook(bookModel);
            usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(userId)).bookModel(bookModel).type("Мои").build());
        }
        return findUserBooks(userId);
    }

    public List<BookDTO> deleteUserBook(long userId, long bookId) {
        usersBooksRepository.deleteUsersBook(userId, bookId);
        return findUserBooks(userId);
    }
    
    public List<BookDTO> findUserDesiredBook(long userId) {
        return BookMapper.BOOK_MAPPER.bookModelsToBookDTOs(bookRepository.findAllUsersDesiredBooks(userId));
    }

    public List<BookDTO> saveDesiredBook(long userId, BookModel bookModel) {
        if (bookModel.getId() != 0){
            usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(userId)).bookModel(bookRepository.getById(bookModel.getId())).type("Мои").build());
        }else{
            createNewBook(bookModel);
            usersBooksRepository.save(UsersBooksModel.builder().usersModel(usersRepository.findById(userId)).bookModel(bookModel).type("Желаемые").build());
        }
        return findUserBooks(userId);
    }

    public List<BookDTO> deleteUserDesiredBook(long userId, long bookId) {
        usersBooksRepository.deleteUsersDesiredBook(userId, bookId);
        return findUserDesiredBook(userId);
    }

    private void createNewBook(BookModel bookModel) {
        Set<AuthorModel> authorModels = new HashSet<>();
        Set<CategoryModel> categoryModels = new HashSet<>();
        Set<GenreModel> genreModels  = new HashSet<>();

        for (AuthorModel authorModel : bookModel.getAuthors()){
            AuthorModel tmp = authorRepository.findByFirstnameAndLastname(authorModel.getFirstname(), authorModel.getLastname());
            if (tmp != null){ authorModels.add(tmp); }
            else{ authorModels.add(authorRepository.save(authorModel)); }
        }

        for (CategoryModel categoryModel : bookModel.getCategories()){
            CategoryModel tmp = categoryRepository.findByName(categoryModel.getName());
            if (tmp != null){ categoryModels.add(tmp); }
            else{ categoryModels.add(categoryRepository.save(categoryModel)); }
        }

        for (GenreModel genreModel : bookModel.getGenres()){
            GenreModel tmp = genreRepository.findByName(genreModel.getName());
            if (tmp != null){ genreModels.add(tmp); }
            else{ genreModels.add(genreRepository.save(genreModel)); }
        }

        bookModel.setAuthors(authorModels);
        bookModel.setCategories(categoryModels);
        bookModel.setGenres(genreModels);

        bookRepository.save(bookModel);
    }


    public List<BookDTO> findAllBooks() {
        List<BookModel> bookModels = bookRepository.findAll();
        List<BookDTO> bookDTOs = new ArrayList<>();
        double tmp = 0;

        for(BookModel bookModel : bookModels ){
            for (BookUserRatingModel bookUserRatingModel : bookModel.getBookUserRatings()){
                tmp += bookUserRatingModel.getGrade();
            }
            BookDTO bookDTO = BookMapper.BOOK_MAPPER.bookModelToBookDTO(bookModel);
            bookDTO.setRating(tmp/bookModel.getBookUserRatings().size());
            bookDTOs.add(bookDTO);
            tmp = 0;
        }
        return bookDTOs;
    }

    public BookPageDTO findBook(long bookId) {
        BookModel bookModel = bookRepository.findById(bookId);
        double tmp = 0;

        for (BookUserRatingModel bookUserRatingModel : bookModel.getBookUserRatings()){
            tmp += bookUserRatingModel.getGrade();
        }

        BookPageDTO bookPageDTO = BookMapper.BOOK_MAPPER.bookModelToBookPageDTO(bookModel);
        bookPageDTO.setRating(tmp/bookModel.getBookUserRatings().size());

        return bookPageDTO;
    }

    public List<BookDTO> findByBookName(String bookName) {
        return BookMapper.BOOK_MAPPER.bookModelsToBookDTOs(bookRepository.findByBookName(bookName));
    }

    public BookPageDTO addComment(long bookId, long userId, String comment) {
        bookUserCommentRepository.save(BookUserCommentModel.builder().
                bookModel(bookRepository.getById(bookId)).
                usersModel(usersRepository.findById(userId)).
                comment(comment).build());
        return findBook(bookId);
    }

    public BookPageDTO addRating(long bookId, long userId, int grade) {
        BookUserRatingModel bookUserRatingModel = bookUserRatingRepository.findByUsersModelIdAndBookModelId(userId, bookId);
        if(bookUserRatingModel != null){ bookUserRatingRepository.updateRating(userId, bookId, grade); }
        else{ bookUserRatingRepository.save(BookUserRatingModel.builder().
                bookModel(bookRepository.getById(bookId)).
                usersModel(usersRepository.findById(userId)).
                grade(grade).build()); }
        return findBook(bookId);
    }

}

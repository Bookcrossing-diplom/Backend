package com.bookcrossing.service;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.mapper.BookMapper;
import com.bookcrossing.mapper.UserMapper;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.CategoryModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.BookRepository;
import com.bookcrossing.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BookRepository bookRepository;

    public UsersDTO findById(long id) {
        return UserMapper.USER_MAPPER.usersToUsersDTO(usersRepository.findById(id));
    }

    public UsersDTO updateInfo(UsersModel usersModel) {
        if (usersModel.getFirstname() != null){ usersRepository.updateFirstname(usersModel.getId(), usersModel.getFirstname()); }
        if (usersModel.getLastname() != null){ usersRepository.updateLastname(usersModel.getId(), usersModel.getLastname()); }
        if (usersModel.getCity() != null){ usersRepository.updateCity(usersModel.getId(), usersModel.getCity()); }
        if (usersModel.getEmail() != null){ usersRepository.updateEmail(usersModel.getId(), usersModel.getEmail()); }

        if (usersModel.getCategories() != null){
//            usersRepository.updateCategory(usersModel.getId(), usersModel.getCategories());
            }
        return UserMapper.USER_MAPPER.usersToUsersDTO(usersRepository.findById(usersModel.getId()));
    }

    public List<BookDTO> findMyBook(long id) {
        return BookMapper.BOOK_MAPPER.bookModelToBookDTO(bookRepository.findAllUsersBooks(id));
    }
//
//    public List<BookInfoAll> findDesiredUsersBook(long id) {
//        return usersRepository.findDesiredUsersBook(id);
//    }

//    public List<BookModel> updateMyBook(long id, BookModel bookModel) {
//        List<BookModel> bookModels;
//        return null;
//    }
//
//    public List<BookModel> updateDesiredUsersBook(long id, BookModel bookModel) {
//        return null;
//    }
}



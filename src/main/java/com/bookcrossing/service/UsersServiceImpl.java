package com.bookcrossing.service;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.mapper.BookMapper;
import com.bookcrossing.mapper.UserMapper;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.BookRepository;
import com.bookcrossing.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return UserMapper.USER_MAPPER.usersToUsersDTO(usersRepository.findById(usersModel.getId()));
    }

    public List<BookModel> findMyBook(long id) {
        List<BookModel> tmp  =  bookRepository.findAllUsersBooks(id);
        List<BookDTO> tmp1 = new ArrayList<>();
        for(BookModel bookModel : tmp){
            BookDTO bookDTO = BookMapper.BOOK_MAPPER.bookModelToBookDTO(bookModel);
            tmp1.add(bookDTO);
        }

        System.out.println();
        return tmp;
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



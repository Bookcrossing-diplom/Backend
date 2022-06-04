package com.bookcrossing.service;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.mapper.UserMapper;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BookServiceImpl bookService;

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
        return bookService.findMyBook(id);
    }

    public List<BookDTO> saveMyBook(long id, BookModel bookModel) {
        return bookService.saveMyBook(id, bookModel);
    }

    public List<BookDTO> deleteUsersBook(long userId, long bookId) {
        return bookService.deleteUsersBook(userId, bookId);
    }

    public List<BookDTO> findUsersDesiredBook(long id) {
        return bookService.findUsersDesiredBook(id);
    }

    public List<BookDTO> saveDesiredBook(long id, BookModel bookModel) {
        return bookService.saveDesiredBook(id, bookModel);
    }

    public List<BookDTO> deleteUsersDesiredBook(long userId, long bookId) {
        return bookService.deleteUsersDesiredBook(userId, bookId);
    }
}



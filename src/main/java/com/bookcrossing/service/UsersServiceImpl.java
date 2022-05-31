package com.bookcrossing.service;

import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.UsersPersonalOfficeInfo;
import com.bookcrossing.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    public UsersPersonalOfficeInfo findById(long id) {
        return usersRepository.findById(id);
    }

    public UsersPersonalOfficeInfo updateInfo(UsersModel usersModel) {
        if (usersModel.getFirstname() != null){ usersRepository.updateFirstname(usersModel.getId(), usersModel.getFirstname()); }
        if (usersModel.getLastname() != null){ usersRepository.updateLastname(usersModel.getId(), usersModel.getLastname()); }
        if (usersModel.getCity() != null){ usersRepository.updateCity(usersModel.getId(), usersModel.getCity()); }
        return usersRepository.findById(usersModel.getId());
    }

    public List<BookModel> findMyBook(long id) {
        return usersRepository.findMyBook(id);
    }

    public List<BookModel> findDesiredUsersBook(long id) {
        return usersRepository.findDesiredUsersBook(id);
    }

    public List<BookModel> updateMyBook(long id, BookModel bookModel) {
        List<BookModel> bookModels;
        return null;
    }

    public List<BookModel> updateDesiredUsersBook(long id, BookModel bookModel) {
        return null;
    }
}



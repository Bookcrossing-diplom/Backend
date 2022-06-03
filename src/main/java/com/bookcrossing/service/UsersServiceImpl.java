package com.bookcrossing.service;

import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.mapper.UserMapper;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
//import com.bookcrossing.dto.BookInfo;
//import com.bookcrossing.dto.BookInfoAll;
//import com.bookcrossing.dto.UsersPersonalOfficeInfo;
import com.bookcrossing.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

//    private UserMapper userMapper;

    public UsersDTO findById(long id) {
        UsersModel usersModel = usersRepository.findById(id);
        UsersDTO usersDTO = UserMapper.USER_MAPPER.usersToUsersDTO(usersModel);
        return null;
    }

//    public UsersDTO updateInfo(UsersModel usersModel) {
//        if (usersModel.getFirstname() != null){ usersRepository.updateFirstname(usersModel.getId(), usersModel.getFirstname()); }
//        if (usersModel.getLastname() != null){ usersRepository.updateLastname(usersModel.getId(), usersModel.getLastname()); }
//        if (usersModel.getCity() != null){ usersRepository.updateCity(usersModel.getId(), usersModel.getCity()); }
//        return usersRepository.findById(usersModel.getId());
//    }

//    public List<BookInfo> findMyBook(long id) {
//        return usersRepository.findMyBook(id);
//    }
//
//    public List<BookInfoAll> findDesiredUsersBook(long id) {
//        return usersRepository.findDesiredUsersBook(id);
//    }

    public List<BookModel> updateMyBook(long id, BookModel bookModel) {
        List<BookModel> bookModels;
        return null;
    }

    public List<BookModel> updateDesiredUsersBook(long id, BookModel bookModel) {
        return null;
    }
}



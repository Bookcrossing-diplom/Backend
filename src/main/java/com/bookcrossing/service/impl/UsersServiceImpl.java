package com.bookcrossing.service.impl;

import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.mapper.UserMapper;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.UsersRepository;
import com.bookcrossing.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BookServiceImpl bookService;

    public UsersDTO findById(long userId) {
        return UserMapper.USER_MAPPER.usersToUsersDTO(usersRepository.findById(userId));
    }

    public UsersDTO updateUserInfo(UsersDTO usersDTO) {
        if (usersDTO.getFirstname() != null){ usersRepository.updateFirstname(usersDTO.getId(), usersDTO.getFirstname()); }
        if (usersDTO.getLastname() != null){ usersRepository.updateLastname(usersDTO.getId(), usersDTO.getLastname()); }
        if (usersDTO.getCity() != null){ usersRepository.updateCity(usersDTO.getId(), usersDTO.getCity()); }
        if (usersDTO.getEmail() != null){ usersRepository.updateEmail(usersDTO.getId(), usersDTO.getEmail()); }

        if (usersDTO.getCategories() != null){
//            usersRepository.updateCategory(usersModel.getId(), usersModel.getCategories());
            }
        return UserMapper.USER_MAPPER.usersToUsersDTO(usersRepository.findById(usersDTO.getId()));
    }

}



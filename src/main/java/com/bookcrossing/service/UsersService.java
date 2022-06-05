package com.bookcrossing.service;

import com.bookcrossing.dto.UsersDTO;

public interface UsersService {
    UsersDTO findById(long id);

    UsersDTO updateUserInfo(UsersDTO usersDTO);

}

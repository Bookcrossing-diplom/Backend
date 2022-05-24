package com.bookcrossing.service;

import com.bookcrossing.model.UserModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
//надо также как и в репозитории
    UserModel getUserByEmail(String email);

    List<UserModel> getAllUsers();

}

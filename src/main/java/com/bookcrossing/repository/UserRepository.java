package com.bookcrossing.repository;

import com.bookcrossing.model.UserModel;

public interface UserRepository {
    UserModel getById(Long userId);
    UserModel getByLogin(String userLogin);
    UserModel createUser(UserModel userModel);
}

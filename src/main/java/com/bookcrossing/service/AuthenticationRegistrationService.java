package com.bookcrossing.service;

import com.bookcrossing.exception.ExistingEmailException;
import com.bookcrossing.exception.ExistingLoginException;
import com.bookcrossing.exception.UncorrectLoginException;
import com.bookcrossing.exception.UncorrectPasswordException;
import com.bookcrossing.model.AuthModel;
import com.bookcrossing.model.UsersModel;

public interface AuthenticationRegistrationService {
    long auth(AuthModel authModel) throws UncorrectLoginException, UncorrectPasswordException;

    long reg(UsersModel usersModel) throws ExistingLoginException, ExistingEmailException;
}

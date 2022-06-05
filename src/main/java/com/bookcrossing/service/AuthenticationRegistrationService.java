package com.bookcrossing.service;

import com.bookcrossing.exception.ExistingEmailException;
import com.bookcrossing.exception.ExistingLoginException;
import com.bookcrossing.exception.UncorrectLoginException;
import com.bookcrossing.exception.UncorrectPasswordException;
import com.bookcrossing.dto.AuthorizationDTO;
import com.bookcrossing.model.UsersModel;

public interface AuthenticationRegistrationService {
    long auth(AuthorizationDTO authorizationDTO) throws UncorrectLoginException, UncorrectPasswordException;

    long reg(UsersModel usersModel) throws ExistingLoginException, ExistingEmailException;
}

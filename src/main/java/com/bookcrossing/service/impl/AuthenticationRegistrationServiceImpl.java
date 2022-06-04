package com.bookcrossing.service.impl;

import com.bookcrossing.exception.ExistingEmailException;
import com.bookcrossing.exception.ExistingLoginException;
import com.bookcrossing.exception.UncorrectLoginException;
import com.bookcrossing.exception.UncorrectPasswordException;
import com.bookcrossing.model.AuthModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.UsersRepository;
import com.bookcrossing.service.AuthenticationRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationRegistrationServiceImpl implements AuthenticationRegistrationService {
    @Autowired
    UsersRepository usersRepository;

    public long auth(AuthModel authModel) throws UncorrectPasswordException, UncorrectLoginException {
        UsersModel usersModel = usersRepository.findByLogin(authModel.getLogin());
        if (Objects.isNull(usersModel)) { throw new UncorrectLoginException(); }
        if (authModel.getPassword().equals(usersModel.getPassword())){ return usersModel.getId(); }
        else { throw new UncorrectPasswordException(); }
    }

    public long reg(UsersModel usersModel) throws ExistingLoginException, ExistingEmailException {
        if (usersRepository.existsByLogin(usersModel.getLogin())){ throw new ExistingLoginException();}
        if (usersRepository.existsByEmail(usersModel.getEmail())){ throw new ExistingEmailException();}
        return usersRepository.save(usersModel).getId();

    }

}

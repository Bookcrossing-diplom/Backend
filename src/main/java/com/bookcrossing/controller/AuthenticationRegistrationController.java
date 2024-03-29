package com.bookcrossing.controller;

import com.bookcrossing.exception.ExistingEmailException;
import com.bookcrossing.exception.ExistingLoginException;
import com.bookcrossing.exception.UncorrectLoginException;
import com.bookcrossing.exception.UncorrectPasswordException;
import com.bookcrossing.dto.AuthorizationDTO;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.service.impl.AuthenticationRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRegistrationController {
    @Autowired
    AuthenticationRegistrationServiceImpl authenticationRegistrationService;

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthorizationDTO authorizationDTO){
        try {
            long id = authenticationRegistrationService.auth(authorizationDTO);
            return ResponseEntity.ok().body(Long.toString(id));
        } catch (UncorrectLoginException e) {
            return ResponseEntity.badRequest().body("Неверный логин:" + authorizationDTO.getLogin());
        } catch (UncorrectPasswordException e) {
            return ResponseEntity.badRequest().body("Неверный пароль");
        }
    }

    @PostMapping("/reg")
    public ResponseEntity<Object> reg(@RequestBody UsersModel usersModel){
        try {
            return ResponseEntity.ok().body( Long.toString(authenticationRegistrationService.reg(usersModel)));
        } catch (ExistingLoginException e) {
            return ResponseEntity.badRequest().body("Данный логин уже существует");
        } catch (ExistingEmailException e) {
            return ResponseEntity.badRequest().body("Данная почта уже существует");
        }
    }

}

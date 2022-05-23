package com.bookcrossing.controller;

import com.bookcrossing.BookcrossingMainProjectApplication;
import com.bookcrossing.model.UserModel;

import com.bookcrossing.repository.UserRepository;
import com.google.gson.Gson;
import com.bookcrossing.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(BookcrossingMainProjectApplication.class);


    private static final Gson gson = new Gson();

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/reg")
    public String registration() {
        return "reg";
    }

    @PostMapping("/reg")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
        return new ResponseEntity<>(userRepository.createUser(userModel), HttpStatus.CREATED);

    }

    @GetMapping("/auth")
    public String authentication() {
        return "auth";
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> getByLogin(@RequestBody UserModel userModel, HttpServletResponse response) {
        logger.info("XYU ");
        UserModel userModel1 = userRepository.getByLogin(userModel.getLogin());
        if (userModel1 == null || !userModel.getPassword().equals(userModel1.getPassword())) {
            return new ResponseEntity<>(gson.toJson("no token"), HttpStatus.UNAUTHORIZED);
        }
        logger.info("YA TUTA");


        String token = authenticationService.startSession(userModel1.getId());
        logger.info(token);
        response.addCookie(new Cookie("token", token));

        return new ResponseEntity<>(gson.toJson(token), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }


    //коментарий 1123
    @GetMapping("/profile/json")
    public ResponseEntity<Object> profile(@CookieValue(value = "token", required = false) String token) {
        Long userId = authenticationService.getUserIdByToken(token);
        return new ResponseEntity<>(userRepository.getById(userId), HttpStatus.OK);
    }

}
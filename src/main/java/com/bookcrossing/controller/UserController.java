package com.bookcrossing.controller;

import com.bookcrossing.model.UserModel;
import com.bookcrossing.repository.UserRepository;
import com.bookcrossing.service.UserService;
import com.bookcrossing.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/qwerty")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user")
    public ResponseEntity<UserModel> getUserByEmail(@RequestParam String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }


    @GetMapping("/qwe")
    public ResponseEntity<List<UserModel>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}

package com.bookcrossing.controller;

import com.bookcrossing.model.UserModel;
import com.bookcrossing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAllUser(){
        List<UserModel> userModels = new ArrayList<UserModel>();
        userModels.addAll(userRepository.findAll());
        System.out.println();
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
//            List<UserModel> userModels = new ArrayList<UserModel>();
    }
}

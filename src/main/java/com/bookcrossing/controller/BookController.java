package com.bookcrossing.controller;

import com.bookcrossing.BookcrossingMainProjectApplication;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.repository.BookRepository;
import com.bookcrossing.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookcrossingMainProjectApplication.class);


    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/favorite")
    public String favorite(){
        return "favorite";
    }


    @GetMapping("/myBooks")
    public String myBooks(){
        return "myBooks";
    }

    @GetMapping("/myBooks/getAll")
    public ResponseEntity<List<BookModel>> myBooks(@CookieValue(value = "token", required = false) String token){
        Long id = authenticationService.getUserIdByToken(token);
        logger.info("YA tut" + id.toString());
        return new ResponseEntity<>(bookRepository.getAllBook(id), HttpStatus.OK);
//        return ResponseEntity<>(bookRepository.getAllBook(), HttpStatus.OK);
    }

//    @PostMapping("/myBooks/add")
//    public ResponseEntity<BookRepository> createBook(){
//
//
//    }


}

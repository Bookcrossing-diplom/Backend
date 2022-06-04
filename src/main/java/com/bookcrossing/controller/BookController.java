package com.bookcrossing.controller;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.model.AuthorModel;
import com.bookcrossing.model.BookForSearchModel;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.CategoryModel;
import com.bookcrossing.service.impl.AuthorServiceImpl;
import com.bookcrossing.service.impl.BookServiceImpl;
import com.bookcrossing.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/")
    public ResponseEntity<List<BookForSearchModel>> findAllBooks(){
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @GetMapping ("/search")
    ResponseEntity<List<BookDTO>> findByBookName(@RequestParam String bookName){
        return ResponseEntity.ok().body(bookService.findByBookName(bookName));
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryModel>> findAllCategoryWithGenre(){
        return ResponseEntity.ok().body(categoryService.findAllCategoryWithGenre());
    }

    @GetMapping("/author")
    public ResponseEntity<List<AuthorModel>> findAllAuthor(){
        return ResponseEntity.ok().body(authorService.findAll());
    }

}

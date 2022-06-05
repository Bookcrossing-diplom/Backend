package com.bookcrossing.controller;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.BookPageDTO;
import com.bookcrossing.model.AuthorModel;
import com.bookcrossing.model.CategoryModel;
import com.bookcrossing.service.impl.AuthorServiceImpl;
import com.bookcrossing.service.impl.BookServiceImpl;
import com.bookcrossing.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<BookDTO>> findAllBooks(){
        return ResponseEntity.ok().body(bookService.findAllBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookPageDTO> findBook(@PathVariable long bookId){
        return ResponseEntity.ok().body(bookService.findBook(bookId));
    }

    @PostMapping("/{bookId}/addComment")
    public ResponseEntity<BookPageDTO> addComment(@PathVariable long bookId, @RequestParam long userId, @RequestParam String comment){
        return ResponseEntity.ok().body(bookService.addComment(bookId, userId, comment));
    }

    @PostMapping("/{bookId}/addRating")
    public ResponseEntity<BookPageDTO> addRating(@PathVariable long bookId, @RequestParam long userId, @RequestParam int grade){
        return ResponseEntity.ok().body(bookService.addRating(bookId, userId, grade));
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

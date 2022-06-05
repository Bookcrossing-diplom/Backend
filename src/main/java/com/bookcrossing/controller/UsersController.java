package com.bookcrossing.controller;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.service.impl.BookServiceImpl;
import com.bookcrossing.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/{userId}")
    public ResponseEntity<UsersDTO> findById(@PathVariable long userId){
        return ResponseEntity.ok().body(usersService.findById(userId));
    }

    @PutMapping("/{userId}/update")
    public ResponseEntity<UsersDTO> updateUserInfo(@PathVariable long userId, @RequestBody UsersDTO usersDTO){
        return ResponseEntity.ok().body(usersService.updateUserInfo(usersDTO));
    }

    @GetMapping("/{userId}/mybook")
    public ResponseEntity<List<BookDTO>> findUserBooks(@PathVariable long userId){
        return ResponseEntity.ok(bookService.findUserBooks(userId));
    }

    @PostMapping("/{userId}/addMybook")
    public ResponseEntity<List<BookDTO>> saveUserBooks(@PathVariable long userId, @RequestBody BookModel bookModel){
        return ResponseEntity.ok(bookService.saveUserBook(userId, bookModel));
    }

    @DeleteMapping("/{userId}/deleteMybook")
    public ResponseEntity<List<BookDTO>> deleteUserBook(@PathVariable long userId, @RequestParam long bookId){
        return ResponseEntity.ok().body(bookService.deleteUserBook(userId, bookId));
    }

    @GetMapping("/{userId}/desired")
    public ResponseEntity<List<BookDTO>> findUsersDesiredBook(@PathVariable long userId){
        return ResponseEntity.ok(bookService.findUserDesiredBook(userId));
    }

    @PostMapping("/{userId}/addDesiredbook")
    public ResponseEntity<List<BookDTO>> saveUsersDesiredBook(@PathVariable long userId,  @RequestBody BookModel bookModel) {
        return ResponseEntity.ok(bookService.saveDesiredBook(userId, bookModel));
    }

    @DeleteMapping("/{userId}/deleteDesiredbook")
    public ResponseEntity<List<BookDTO>> deleteUserDesiredBook(@PathVariable long userId, @RequestParam long bookId){
        return ResponseEntity.ok().body(bookService.deleteUserDesiredBook(userId, bookId));
    }

}

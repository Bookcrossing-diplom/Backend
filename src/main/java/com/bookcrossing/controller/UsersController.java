package com.bookcrossing.controller;

import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.UsersPersonalOfficeInfo;
import com.bookcrossing.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersServiceImpl usersService;

    @GetMapping("/{id}")
    public ResponseEntity<UsersPersonalOfficeInfo> findById(@PathVariable String id){
        return ResponseEntity.ok().body(usersService.findById(Long.parseLong(id)));
    }

    @PutMapping("/update")
    public ResponseEntity<UsersPersonalOfficeInfo> updateInfo(@RequestBody UsersModel usersModel){
        return ResponseEntity.ok().body(usersService.updateInfo(usersModel));
    }

    @GetMapping("/{id}/mybook")
    public ResponseEntity<List<BookModel>> findUsersBook(@PathVariable String id){
        return ResponseEntity.ok(usersService.findMyBook(Long.parseLong(id)));
    }

    @GetMapping("/{id}/desired")
    public ResponseEntity<List<BookModel>> findDesiredUsersBook(@PathVariable String id){
        return ResponseEntity.ok(usersService.findDesiredUsersBook(Long.parseLong(id)));
    }

    @PutMapping("/{id}/mybook")
    public ResponseEntity<List<BookModel>> updateUsersBook(@PathVariable String id, BookModel bookModel){
        return ResponseEntity.ok(usersService.updateMyBook(Long.parseLong(id), bookModel));
    }

    @PutMapping("/{id}/desired")
    public ResponseEntity<List<BookModel>> updateDesiredUsersBook(@PathVariable String id, BookModel bookModel){
        return ResponseEntity.ok(usersService.updateDesiredUsersBook(Long.parseLong(id), bookModel));
    }

}

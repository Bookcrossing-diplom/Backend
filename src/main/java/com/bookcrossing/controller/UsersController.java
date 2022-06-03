package com.bookcrossing.controller;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
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
    public ResponseEntity<UsersDTO> findById(@PathVariable long id){
        return ResponseEntity.ok().body(usersService.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<UsersDTO> updateInfo(@RequestBody UsersModel usersModel){
        return ResponseEntity.ok().body(usersService.updateInfo(usersModel));
    }

    @GetMapping("/{id}/mybook")
    public ResponseEntity<List<BookDTO>> findUsersBook(@PathVariable long id){
        return ResponseEntity.ok(usersService.findMyBook(id));
    }
//
//    @GetMapping("/{id}/desired")
//    public ResponseEntity<List<BookInfoAll>> findDesiredUsersBook(@PathVariable String id){
//        return ResponseEntity.ok(usersService.findDesiredUsersBook(Long.parseLong(id)));
//    }


//
//    @PutMapping("/{id}/mybook")
//    public ResponseEntity<List<BookModel>> updateUsersBook(@PathVariable String id, BookModel bookModel){
//        return ResponseEntity.ok(usersService.updateMyBook(Long.parseLong(id), bookModel));
//    }
//
//    @PutMapping("/{id}/desired")
//    public ResponseEntity<List<BookModel>> updateDesiredUsersBook(@PathVariable String id, BookModel bookModel){
//        return ResponseEntity.ok(usersService.updateDesiredUsersBook(Long.parseLong(id), bookModel));
//    }

}

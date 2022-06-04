package com.bookcrossing.controller;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersModel;
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

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> findById(@PathVariable long id){
        return ResponseEntity.ok().body(usersService.findById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<UsersDTO> updateInfo(@PathVariable long id, @RequestBody UsersModel usersModel){
        return ResponseEntity.ok().body(usersService.updateInfo(usersModel));
    }

    @GetMapping("/{id}/mybook")
    public ResponseEntity<List<BookDTO>> findUsersBook(@PathVariable long id){
        return ResponseEntity.ok(usersService.findMyBook(id));
    }

    @PostMapping("/{id}/addMybook")
    public ResponseEntity<List<BookDTO>> saveUsersBook(@PathVariable long id,@RequestBody BookModel bookModel){
        return ResponseEntity.ok(usersService.saveMyBook(id, bookModel));
    }

    @DeleteMapping("/{userId}/deleteMybook")
    public ResponseEntity<List<BookDTO>> deleteUsersBook(@PathVariable long userId, @RequestParam long bookId){
        return ResponseEntity.ok().body(usersService.deleteUsersBook(userId, bookId));
    }

    @GetMapping("/{id}/desired")
    public ResponseEntity<List<BookDTO>> findUsersDesiredBook(@PathVariable String id){
        return ResponseEntity.ok(usersService.findUsersDesiredBook(Long.parseLong(id)));
    }

    @PostMapping("/{id}/addDesiredbook")
    public ResponseEntity<List<BookDTO>> saveUsersDesiredBook(@PathVariable long id,@RequestBody BookModel bookModel) {
        return ResponseEntity.ok(usersService.saveDesiredBook(id, bookModel));
    }

    @DeleteMapping("/{userId}/deleteDesiredbook")
    public ResponseEntity<List<BookDTO>> deleteUsersDesiredBook(@PathVariable long userId, @RequestParam long bookId){
        return ResponseEntity.ok().body(usersService.deleteUsersDesiredBook(userId, bookId));
    }

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

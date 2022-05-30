package com.bookcrossing.controller;

import com.bookcrossing.model.BookModel;
import com.bookcrossing.model.UsersBooksModel;
import com.bookcrossing.model.UsersModel;
import com.bookcrossing.repository.BookRepository;
import com.bookcrossing.repository.UserRepository;
import com.bookcrossing.repository.UsersBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/data")
public class DataFillingController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UsersBooksRepository usersBooksRepository;

    @GetMapping("/")
    public ResponseEntity<String> fillingData(){
        UsersModel usersModel = UsersModel.builder().login("ikyz9").password("123").firstname("Илья").lastname("Кузнецов").email("ikyz9@gmail.com").city("Саратов").build();
        UsersModel usersModel1 = UsersModel.builder().login("tuda").password("suda").firstname("Тутанхомон").lastname("третий").email("tudasuda@gmail.com").city("Новосибирск").build();
        UsersModel usersModel2 = UsersModel.builder().login("mimika").password("qwe").firstname("Мим").lastname("Денисов").email("mimika9@gmail.com").city("Санкт-Петербург").build();
        UsersModel usersModel3 =UsersModel.builder().login("zxc").password("zxc").firstname("крик").lastname("луны").email("zxc1vs1@gmail.com").city("Челябинск").build();
        userRepository.saveAll(Arrays.asList(usersModel,usersModel1,usersModel2,usersModel3));

        BookModel bookModel = BookModel.builder().name("Война и мир").edition("если есть много свободного времени").yearPublishing("1990").build();
        BookModel bookModel1 = BookModel.builder().name("Отцы и дети").edition("Как же хорошо вернуться домой").yearPublishing("2006").build();
        BookModel bookModel2 = BookModel.builder().name("Преступление и наказание").edition("Как мужик поддался своей жадности").yearPublishing("2000").build();
        BookModel bookModel3 = BookModel.builder().name("Мастер и маргарита").edition("Все очень запутано").yearPublishing("2001").build();
        BookModel bookModel4 = BookModel.builder().name("Повесть о настоящем человеке").edition("Название говорит само за себя").yearPublishing("1993").build();
        BookModel bookModel5 = BookModel.builder().name("Судьба человека").edition("История одного военнослужащего").yearPublishing("1983").build();
        BookModel bookModel6 = BookModel.builder().name("Собачье сердце").edition("Что значит проводить опыты на людях").yearPublishing("2006").build();
        BookModel bookModel7 = BookModel.builder().name("Евгений Онегин").edition("Когда чуть-чуть не успел").yearPublishing("1990").build();

        bookRepository.saveAll(Arrays.asList(bookModel,bookModel1,bookModel2,bookModel3,bookModel4,bookModel5,bookModel6,bookModel7));

        usersBooksRepository.saveAll(
                Arrays.asList(
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel3).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel7).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel2).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel6).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel6).type("Мои").build(),

                        UsersBooksModel.builder().usersModel(usersModel1).bookModel(bookModel).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel1).bookModel(bookModel5).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel1).bookModel(bookModel7).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel1).bookModel(bookModel3).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel1).bookModel(bookModel1).type("Мои").build(),

                        UsersBooksModel.builder().usersModel(usersModel2).bookModel(bookModel4).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel2).bookModel(bookModel6).type("Мои").build(),

                        UsersBooksModel.builder().usersModel(usersModel3).bookModel(bookModel).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel3).bookModel(bookModel2).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel3).bookModel(bookModel2).type("Мои").build(),

                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel5).type("Желаемые").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel).type("Желаемые").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel4).type("Желаемые").build(),

                        UsersBooksModel.builder().usersModel(usersModel3).bookModel(bookModel3).type("Желаемые").build(),
                        UsersBooksModel.builder().usersModel(usersModel3).bookModel(bookModel6).type("Желаемые").build(),

                        UsersBooksModel.builder().usersModel(usersModel2).bookModel(bookModel5).type("Желаемые").build(),

                        UsersBooksModel.builder().usersModel(usersModel1).bookModel(bookModel4).type("Желаемые").build()
                )
        );


        return ResponseEntity.ok().body("All good");
    }

}

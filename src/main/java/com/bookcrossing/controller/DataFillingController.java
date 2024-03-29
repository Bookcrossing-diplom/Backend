package com.bookcrossing.controller;

import com.bookcrossing.model.*;
import com.bookcrossing.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping("/data")
public class DataFillingController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UsersBooksRepository usersBooksRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    NewsFeedRepository newsFeedRepository;

    @Autowired
    BookUserRatingRepository bookUserRatingRepository;

    @Autowired
    BookUserCommentRepository bookUserCommentRepository;


    @GetMapping("/")
    public ResponseEntity<String> fillingData(){
        //creation all models

        AuthorModel authorModel = AuthorModel.builder().firstname("Александр").lastname("Пушкин").country("Российская империя").century("19 век").build();
        AuthorModel authorModel1 = AuthorModel.builder().firstname("Лев").lastname("Толстой").country("Российская империя").century("19 век").build();
        AuthorModel authorModel2 = AuthorModel.builder().firstname("Иван").lastname("Тургенев").country("Российская империя").century("19 век").build();
        AuthorModel authorModel3 = AuthorModel.builder().firstname("Федор").lastname("Достоевский").country("Российская империя").century("19 век").build();
        AuthorModel authorModel4 = AuthorModel.builder().firstname("Михаил").lastname("Булгаков").country("Российская империя").century("20 век").build();
        AuthorModel authorModel5 = AuthorModel.builder().firstname("Борис").lastname("Полевой").country("Российская империя").century("20 век").build();
        AuthorModel authorModel6 = AuthorModel.builder().firstname("Михаил").lastname("Шолохов").country("Российская империя").century("20 век").build();
        authorRepository.saveAll(Arrays.asList(authorModel,authorModel1,authorModel2,authorModel3,authorModel4,authorModel5,authorModel6));

        GenreModel genreModel = GenreModel.builder().name("Роман").build();
        GenreModel genreModel1 = GenreModel.builder().name("Русская классика").build();
        GenreModel genreModel2 = GenreModel.builder().name("Классическая проза").build();
        GenreModel genreModel3 = GenreModel.builder().name("Ужасы").build();
        GenreModel genreModel4 = GenreModel.builder().name("Мистика").build();
        GenreModel genreModel5 = GenreModel.builder().name("Советская литература").build();

        CategoryModel categoryModel = CategoryModel.builder().name("Русская литература").genres(Set.of(genreModel)).build();
        CategoryModel categoryModel1 = CategoryModel.builder().name("Классическая литература").genres(Set.of(genreModel1, genreModel2)).build();
        CategoryModel categoryModel2 = CategoryModel.builder().name("Ужасы, мистика").genres(Set.of(genreModel3, genreModel4)).build();

        BookModel bookModel = BookModel.builder().name("Война и мир").edition("Азбука").yearPublishing("1990").authors(Set.of(authorModel1)).categories(Set.of(categoryModel)).genres(Set.of(genreModel)).build();
        BookModel bookModel1 = BookModel.builder().name("Отцы и дети").edition("СИНБАД").yearPublishing("2006").authors(Set.of(authorModel2)).categories(Set.of(categoryModel1)).genres(Set.of(genreModel1)).build();
        BookModel bookModel2 = BookModel.builder().name("Преступление и наказание").edition("АСТ").yearPublishing("2000").authors(Set.of(authorModel3)).categories(Set.of(categoryModel1)).genres(Set.of(genreModel2)).build();
        BookModel bookModel3 = BookModel.builder().name("Мастер и маргарита").edition("Вече").yearPublishing("2001").authors(Set.of(authorModel4)).categories(Set.of(categoryModel2, categoryModel1)).genres(Set.of(genreModel1, genreModel4)).build();
        BookModel bookModel4 = BookModel.builder().name("Повесть о настоящем человеке").edition("Вече").yearPublishing("1993").authors(Set.of(authorModel5)).categories(Set.of(categoryModel1)).genres(Set.of(genreModel1,genreModel5)).build();
        BookModel bookModel5 = BookModel.builder().name("Судьба человека").edition("Белый город").yearPublishing("1995").authors(Set.of(authorModel6)).categories(Set.of(categoryModel1)).genres(Set.of(genreModel1,genreModel2)).build();
        BookModel bookModel6 = BookModel.builder().name("Собачье сердце").edition("Комильфо").yearPublishing("2006").authors(Set.of(authorModel4)).categories(Set.of(categoryModel1)).genres(Set.of(genreModel2)).build();
        BookModel bookModel7 = BookModel.builder().name("Евгений Онегин").edition("Вита Нова").yearPublishing("1990").authors(Set.of(authorModel)).categories(Set.of(categoryModel1)).genres(Set.of(genreModel1)).build();
        bookRepository.saveAll(Arrays.asList(bookModel,bookModel1,bookModel2,bookModel3,bookModel4,bookModel5,bookModel6,bookModel7));

        UsersModel usersModel = UsersModel.builder().login("ikyz9").password("123").firstname("Илья").lastname("Кузнецов").email("ikyz9@gmail.com").city("Саратов").categories(Set.of(categoryModel2, categoryModel)).build();
        UsersModel usersModel1 = UsersModel.builder().login("elizaveta").password("123").firstname("Елизавета").lastname("Василькова").email("tudasuda@gmail.com").city("Новосибирск").categories(Set.of(categoryModel1)).build();
        UsersModel usersModel2 = UsersModel.builder().login("mimika").password("qwe").firstname("Михаил").lastname("Денисов").email("mimika9@gmail.com").city("Санкт-Петербург").categories(Set.of(categoryModel,categoryModel1)).build();
        UsersModel usersModel3 =UsersModel.builder().login("zxc").password("zxc").firstname("Юлия").lastname("Чаплыгина").email("zxc1vs1@gmail.com").city("Челябинск").categories(Set.of(categoryModel2  )).build();
        usersRepository.saveAll(Arrays.asList(usersModel,usersModel1,usersModel2,usersModel3));

        NewsFeedModel newsFeedModel = NewsFeedModel.builder().heading("Bookcrossing").body("Приложение практически запустилось. Расскажите о нем своим друзьям").dateOfPosting("15/05").build();
        NewsFeedModel newsFeedModel1 = NewsFeedModel.builder().heading("Лето").body("Лето самая прекрасная пора для чтения. Заварите себе чай и в приятной и уютной обстановке возьмите и перечитайте свою любимую книгу.").dateOfPosting("01/01").build();
        NewsFeedModel newsFeedModel2 = NewsFeedModel.builder().heading("Соцсети").body("Отмечайте нас после успешного обмена в соцсетях").dateOfPosting("01/06").build();
        newsFeedRepository.saveAll(
                Arrays.asList((newsFeedModel),
                (newsFeedModel1),
                (newsFeedModel2))
        );

        bookUserRatingRepository.saveAll(
                Arrays.asList(
                        BookUserRatingModel.builder().bookModel(bookModel).usersModel(usersModel).grade(3).build(),
                        BookUserRatingModel.builder().bookModel(bookModel).usersModel(usersModel1).grade(2).build(),
                        BookUserRatingModel.builder().bookModel(bookModel).usersModel(usersModel2).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel).usersModel(usersModel3).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel1).usersModel(usersModel).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel1).usersModel(usersModel2).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel1).usersModel(usersModel3).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel2).usersModel(usersModel1).grade(1).build(),
                        BookUserRatingModel.builder().bookModel(bookModel2).usersModel(usersModel2).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel3).usersModel(usersModel2).grade(4).build(),
                        BookUserRatingModel.builder().bookModel(bookModel4).usersModel(usersModel).grade(3).build(),
                        BookUserRatingModel.builder().bookModel(bookModel4).usersModel(usersModel1).grade(2).build(),
                        BookUserRatingModel.builder().bookModel(bookModel4).usersModel(usersModel2).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel4).usersModel(usersModel3).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel5).usersModel(usersModel).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel5).usersModel(usersModel2).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel5).usersModel(usersModel3).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel6).usersModel(usersModel).grade(2).build(),
                        BookUserRatingModel.builder().bookModel(bookModel6).usersModel(usersModel2).grade(5).build(),
                        BookUserRatingModel.builder().bookModel(bookModel6).usersModel(usersModel3).grade(3).build(),
                        BookUserRatingModel.builder().bookModel(bookModel6).usersModel(usersModel1).grade(4).build(),
                        BookUserRatingModel.builder().bookModel(bookModel7).usersModel(usersModel).grade(4).build(),
                        BookUserRatingModel.builder().bookModel(bookModel7).usersModel(usersModel1).grade(4).build(),
                        BookUserRatingModel.builder().bookModel(bookModel7).usersModel(usersModel2).grade(3).build(),
                        BookUserRatingModel.builder().bookModel(bookModel7).usersModel(usersModel3).grade(4).build()
        ));

        bookUserCommentRepository.saveAll(
                Arrays.asList(
                        BookUserCommentModel.builder().bookModel(bookModel).usersModel(usersModel).comment("Безусловно шедевр. Насколько я могу вообще судить, эту книгу. Это книга, непросто величайший труд автора, но и великий дар для следующих поколений. В ней можно многое почерпнуть, она и актуальна и сегодня. ").build(),
                        BookUserCommentModel.builder().bookModel(bookModel).usersModel(usersModel).comment("Интересно. Смотришь на многие моменты с другой стороны, и понимаешь, что перечитав ее несколько раз, будешь находить и открывать для себя каждый раз что то новое.").build(),
                        BookUserCommentModel.builder().bookModel(bookModel).usersModel(usersModel3).comment("Читается тяжело, на любителя. В школе этого произведения не читала, но и не жалею. Просто хочу для себя прочесть.").build(),
                        BookUserCommentModel.builder().bookModel(bookModel5).usersModel(usersModel3).comment("Великолепная классика в отличном оформлении! История такая душевная, пронзительная и цепляющая. Только перечитывать и перечитывать").build(),
                        BookUserCommentModel.builder().bookModel(bookModel5).usersModel(usersModel2).comment("Проза Шолохова не нуждается в особом представлении: чувственная, пронзительная, трогательная. В книгу входит ряд рассказов и повестей автора").build()
                )
        );

        usersBooksRepository.saveAll(
                Arrays.asList(
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel7).type("Мои").build(),
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel2).type("Мои").build(),
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
                        UsersBooksModel.builder().usersModel(usersModel).bookModel(bookModel1).type("Желаемые").build(),
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

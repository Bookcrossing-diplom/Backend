package com.bookcrossing.repository;

import com.bookcrossing.BookcrossingMainProjectApplication;
import com.bookcrossing.model.BookModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{

    private static final Logger logger = LoggerFactory.getLogger(BookcrossingMainProjectApplication.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BookModel> getAllBook(Long id) {

        List<BookModel> test =   jdbcTemplate.query("SELECT b.name, a.firstname, a.lastname from my_book " +
                "INNER JOIN \"user\" u on u.id = my_book.user_id_fk " +
                "Inner Join author a on a.id = my_book.author_id_fk " +
                "inner join book b on b.id = my_book.book_id_fk " +
                "WHERE user_id_fk = ?", BeanPropertyRowMapper.newInstance(BookModel.class), id);

        return test;
    }
}

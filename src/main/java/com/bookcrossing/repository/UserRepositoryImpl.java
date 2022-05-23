package com.bookcrossing.repository;

import com.bookcrossing.BookcrossingMainProjectApplication;
import com.bookcrossing.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookcrossingMainProjectApplication.class);



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserModel createUser(UserModel userModel) {
        jdbcTemplate.update("INSERT INTO \"user\" (login, password, firstname, lastname, email) VALUES (?, ?, ?, ?, ?)",
                userModel.getLogin(),
                userModel.getPassword(),
                userModel.getFirstname(),
                userModel.getLastname(),
                userModel.getEmail());
        return jdbcTemplate.queryForObject("SELECT * FROM \"user\" WHERE login = ?", BeanPropertyRowMapper.newInstance(UserModel.class), userModel.getLogin());
    }

    @Override
    public UserModel getById(Long userId) {
        return jdbcTemplate.queryForObject("SELECT * FROM \"user\" WHERE id = ?", BeanPropertyRowMapper.newInstance(UserModel.class), userId);
    }

    @Override
    public UserModel getByLogin(String userLogin) {
        logger.info(userLogin + "ЗАходит");
        return jdbcTemplate.queryForObject("SELECT * FROM \"user\" WHERE login = ?", BeanPropertyRowMapper.newInstance(UserModel.class), userLogin);
    }
}

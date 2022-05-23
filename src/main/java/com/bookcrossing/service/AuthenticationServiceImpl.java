package com.bookcrossing.service;

import com.bookcrossing.BookcrossingMainProjectApplication;
import com.bookcrossing.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements com.bookcrossing.service.AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(BookcrossingMainProjectApplication.class);


    @Autowired
    UserRepository userRepository;

    private Map<String, SessionData> authenticatedUsers = new HashMap<>();


    //Добавить проверку и корректную ошибку
    @Override
    public Long getUserIdByToken(String token) {
        return authenticatedUsers.get(token).userId;
    }


    @Override
    public String startSession(Long userId) {
        String token = RandomStringUtils.randomAlphabetic(20);
        Date expiresAt = DateUtils.addHours(new Date(), 2);
        SessionData sessionData = new SessionData(userId, expiresAt);

        authenticatedUsers.put(token, sessionData);

        logger.info(token);
        return token;
    }

    @Override
    public void stopSession(String token) {
        authenticatedUsers.remove(token);
    }


    static class SessionData {
        private Long userId;
        private Date expiresAt;

        public SessionData(Long userId, Date expiresAt) {
            this.userId = userId;
            this.expiresAt = expiresAt;
        }
    }
}


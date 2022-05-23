package com.bookcrossing.service;

public interface AuthenticationService {

    Long getUserIdByToken(String token);
    String startSession(Long userId);
    void stopSession(String token);
}

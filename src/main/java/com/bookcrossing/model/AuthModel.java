package com.bookcrossing.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class AuthModel {
    private String login;
    private String password;
}

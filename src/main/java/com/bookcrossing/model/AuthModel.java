package com.bookcrossing.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AuthModel {
    private String login;
    private String password;
}

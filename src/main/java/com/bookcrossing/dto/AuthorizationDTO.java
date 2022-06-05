package com.bookcrossing.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class AuthorizationDTO {
    private String login;
    private String password;
}

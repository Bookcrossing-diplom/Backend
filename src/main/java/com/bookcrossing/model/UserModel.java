package com.bookcrossing.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name="users")
public class UserModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String email;



}

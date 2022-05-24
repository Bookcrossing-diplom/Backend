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
    private long user_id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;



}

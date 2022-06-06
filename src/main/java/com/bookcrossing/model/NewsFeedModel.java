package com.bookcrossing.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "news_feed")
public class NewsFeedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "heading", length = 80,nullable = false)
    private String heading;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "date_of_posting", length = 50,nullable = false)
    private String dateOfPosting;



}

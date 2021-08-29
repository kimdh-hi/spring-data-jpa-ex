package com.springdatajpa.domain.entity;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(callSuper = true)
public class Review extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private float score;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    @Builder(builderMethodName = "createReview")
    public Review(String title, String content, float score, Book book, User user) {
        this.title = title;
        this.content = content;
        this.score = score;
        this.book = book;
        this.user = user;
    }
}

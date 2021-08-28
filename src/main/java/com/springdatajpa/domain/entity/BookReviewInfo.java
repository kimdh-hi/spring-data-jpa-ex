package com.springdatajpa.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookReviewInfo extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    private float avgReviewScore;

    private int reviewCount;

    @Builder(builderMethodName = "crateBookReviewInfo")
    public BookReviewInfo(Book book, float avgReviewScore, int reviewCount) {
        this.book = book;
        this.avgReviewScore = avgReviewScore;
        this.reviewCount = reviewCount;
    }
}

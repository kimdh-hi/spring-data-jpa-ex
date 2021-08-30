package com.springdatajpa.domain.entity;

import com.springdatajpa.domain.listener.UserHistoryBackupListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Entity
@ToString(callSuper = true)
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String category;

    //== 양방향 - BookReviewInfo ==//
    @OneToOne(mappedBy = "book")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;

    @ManyToMany

    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author... author) {
        this.authors.addAll(Arrays.stream(author).collect(Collectors.toList()));
    }

    @Builder(builderMethodName = "createBook")
    public Book(String title, String content, String category, Publisher publisher) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.publisher = publisher;
    }
}

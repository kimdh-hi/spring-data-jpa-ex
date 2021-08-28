package com.springdatajpa.domain.entity;

import com.springdatajpa.domain.listener.UserHistoryBackupListener;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@ToString
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String category;

    @Builder(builderMethodName = "createBook")
    public Book(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}

package com.springdatajpa.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@ToString(callSuper = true)
public class Author extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @ManyToMany
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public void addBook(Book... book) {
        this.books.addAll(Arrays.stream(book).collect(Collectors.toList()));
    }

    @Builder(builderMethodName = "createTestAuthor")
    public Author(String name) {
        this.name = name;
        this.country = country;
    }
}

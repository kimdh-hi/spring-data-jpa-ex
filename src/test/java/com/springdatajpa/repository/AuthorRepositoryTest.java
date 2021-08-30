package com.springdatajpa.repository;

import com.springdatajpa.domain.entity.Author;
import com.springdatajpa.domain.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired AuthorRepository authorRepository;
    @Autowired BookRepository bookRepository;

    @Test
    @Transactional
    void manyToManyTest() {
        Book bookA = givenBook("cook-bookA");
        Book bookB = givenBook("cook-bookB");
        Book bookC = givenBook("dev-bookA");
        Book bookD = givenBook("dev-bookB");

        Author authorA = givenAuthor("authorA");
        Author authorB = givenAuthor("authorB");
        Author authorC = givenAuthor("authorC");
        Author authorD = givenAuthor("authorD");

        bookA.addAuthor(authorA);
        bookB.addAuthor(authorB);
        bookC.addAuthor(authorC, authorD);
        bookD.addAuthor(authorB, authorD);

        authorA.addBook(bookA, bookC);
        authorB.addBook(bookB, bookD);
        authorC.addBook(bookC);
        authorD.addBook(bookC, bookD);

        bookRepository.saveAll(List.of(bookA, bookB, bookC, bookD));
        authorRepository.saveAll(List.of(authorA, authorB, authorC, authorD));

        List<Author> authors = bookRepository.findAll().get(2).getAuthors();
        System.out.println(">>> book -> author : " + authors);

        List<Book> books = authorRepository.findAll().get(0).getBooks();
        System.out.println(">>> author -> book : " + books);
    }

    private Book givenBook(String title) {
        Book book = Book.createBook()
                .title(title).build();

        return bookRepository.save(book);
    }

    private Author givenAuthor(String name) {
        Author author = Author.createTestAuthor()
                .name(name).build();

        return authorRepository.save(author);
    }
}
package com.springdatajpa.repository;


import com.springdatajpa.domain.entity.Book;
import com.springdatajpa.domain.entity.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired BookRepository bookRepository;


    @Test
    void Read() {
        Book book = initBookData();
        Long bookReviewInfoId = initBookReviewInfo(book);

        BookReviewInfo bookReviewInfo = bookReviewInfoRepository.findById(1L).orElseThrow(IllegalArgumentException::new);
        System.out.println(bookReviewInfo.getBook().getTitle());
    }

    @Test
    void 양방향_테스트() {
        Book book = initBookData();
        Long bookReviewInfoId = initBookReviewInfo(book);

        Book findBook = bookRepository.findById(book.getId()).orElseThrow(IllegalArgumentException::new);



    }

    private Book initBookData() {
        System.out.println(">>> initBookData");

        Book book = Book.createBook()
                .title("BookA")
                .content("BooA is very fun!")
                .category("SF")
                .build();

        return  bookRepository.save(book);
    }

    private Long initBookReviewInfo(Book book) {
        System.out.println(">>> initBookReviewInfoData");

        BookReviewInfo bookReviewInfo = BookReviewInfo.crateBookReviewInfo()
                .book(book)
                .reviewCount(2)
                .avgReviewScore(5.0f)
                .build();

        BookReviewInfo saved = bookReviewInfoRepository.save(bookReviewInfo);

        return saved.getId();
    }
}
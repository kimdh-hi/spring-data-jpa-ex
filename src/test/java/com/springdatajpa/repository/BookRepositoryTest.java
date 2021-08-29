package com.springdatajpa.repository;

import com.springdatajpa.domain.entity.Book;
import com.springdatajpa.domain.entity.Publisher;
import com.springdatajpa.domain.entity.Review;
import com.springdatajpa.domain.entity.User;
import com.springdatajpa.domain.value.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired BookRepository bookRepository;
    @Autowired ReviewRepository reviewRepository;
    @Autowired PublisherRepository publisherRepository;

    @Test
    @Transactional
    void bookRelationTest() {
        getTestData();

        User user = userRepository.findById(1L).get();
        System.out.println("Reviews : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        //System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());
    }

    private void getTestData() {
        getReview(getUser(), getBook());
    }

    private void getReview(User user, Book book) {
        Review review = Review.createReview()
                .title("좋은 책 입니다.").content("꼭 사서 보세용").score(5.0f).book(book).user(user).build();
        reviewRepository.save(review);
    }


    private User getUser() {
        return userRepository.findById(1L).get();
    }

    private Book getBook() {
        Publisher publisher = getPublisher();

        Book book = Book.createBook()
                .title("BookA").content("Very Good book").category("Study").publisher(publisher).build();

        return bookRepository.save(book);
    }

    private Publisher getPublisher() {
        Publisher publisher = Publisher.createPublisher()
                .name("출판사A").address(new Address("서울시", "좋은빌딩")).build();

        return publisherRepository.save(publisher);
    }
}

package com.springdatajpa.repository;

import com.springdatajpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void crud() {
        User user = userRepository.findById(1L).get();

        System.out.println(user);
        System.out.println("updatedAt = " + user.getUpdatedAt());
        System.out.println("createdAt = " + user.getCreatedAt());
        user.setName("modify");

        User savedUser = userRepository.save(user);

        System.out.println(userRepository.findById(savedUser.getId()));
        System.out.println("updatedAt = " + savedUser.getUpdatedAt());
        System.out.println("createdAt = " + savedUser.getCreatedAt());
    }

    @Test
    void entityListenerBackupTest() {
        User user = userRepository.findById(1L).get();
        userHistoryRepository.findAll().forEach(System.out::println);
        user.setName("modify");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }
}

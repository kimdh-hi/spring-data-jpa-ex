package com.springdatajpa.repository;

import com.springdatajpa.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

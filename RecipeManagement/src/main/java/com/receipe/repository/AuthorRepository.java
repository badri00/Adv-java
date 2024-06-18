package com.receipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.receipe.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}

package com.cursoUdemy.libraryapi.model.repository;

import com.cursoUdemy.libraryapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

package com.cursoUdemy.libraryapi.service.imp;

import com.cursoUdemy.libraryapi.model.entity.Book;
import com.cursoUdemy.libraryapi.model.repository.BookRepository;
import com.cursoUdemy.libraryapi.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

    private BookRepository repository;

    public BookServiceImp(BookRepository repository){
        this.repository = repository;
    }

    @Override
    public Book save(Book model) {
        return this.repository.save(model);
    }
}

package com.cursoUdemy.libraryapi.api.resource;

import com.cursoUdemy.libraryapi.api.dto.BookDTO;
import com.cursoUdemy.libraryapi.model.entity.Book;
import com.cursoUdemy.libraryapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto){
        Book model = Book.builder()
            .id(1l)
            .title(dto.getTitle())
            .author(dto.getAuthor())
            .isbn(dto.getIsbn())
            .build();
        Book entity = service.save(model);
        return BookDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .build();
    }

}

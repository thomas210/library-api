package com.cursoUdemy.libraryapi.api.resource;

import com.cursoUdemy.libraryapi.api.dto.BookDTO;
import com.cursoUdemy.libraryapi.model.entity.Book;
import com.cursoUdemy.libraryapi.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;
    private ModelMapper modelMapper;

    public BookController(BookService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto){
        Book model = this.modelMapper.map(dto, Book.class);

        model = service.save(model);

        return this.modelMapper.map(model, BookDTO.class);
    }

}

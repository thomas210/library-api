package com.cursoUdemy.libraryapi.service;

import com.cursoUdemy.libraryapi.model.entity.Book;
import com.cursoUdemy.libraryapi.model.repository.BookRepository;
import com.cursoUdemy.libraryapi.service.imp.BookServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {

    BookService service;

    @MockBean
    BookRepository repository;

    @BeforeEach
    public void setUp(){
        this.service = new BookServiceImp(this.repository);
    }

    @Test
    @DisplayName("Must save a book")
    public void saveBookTest(){

        Book book = Book.builder()
            .title("title book")
            .author("test author")
            .isbn("999-999-999-99-99")
            .build();

        Mockito.when( this.repository.save(book)).thenReturn(
                Book.builder()
                    .id(1l)
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .isbn(book.getIsbn())
                    .build()
        );

        Book savedBook = service.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo(book.getTitle());
        assertThat(savedBook.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(savedBook.getIsbn()).isEqualTo(book.getIsbn());

    }

}

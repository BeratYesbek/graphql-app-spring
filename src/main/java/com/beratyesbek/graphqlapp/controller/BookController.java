package com.beratyesbek.graphqlapp.controller;

import com.beratyesbek.graphqlapp.models.Author;
import com.beratyesbek.graphqlapp.models.Book;
import com.beratyesbek.graphqlapp.repositories.AuthorRepository;
import com.beratyesbek.graphqlapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
@Slf4j
@AllArgsConstructor
public class BookController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @MutationMapping
    public Book createBook(@Argument String name, @Argument int pageCount, @Argument int authorId) {
        Book book = Book.builder().name(name).pageCount(pageCount).author(Author.builder().id(authorId).build()).build();
        return bookRepository.save(book);
    }

    @MutationMapping
    public String deleteBook(@Argument int id) {
        bookRepository.deleteById(id);
        String message = "Book has been deleted successfully";
        return message;
    }

    @MutationMapping
    public Book updateBook(@Argument int id, @Argument String name, @Argument int pageCount, @Argument int authorId) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            book.setName(name);
            book.setAuthor(Author.builder().id(authorId).build());
            book.setPageCount(pageCount);
            bookRepository.save(book);
        }
        return book;
    }


    @QueryMapping
    public Book bookById(@Argument int id) {
        return bookRepository.findById(id).get();
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }

}

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
public class AuthorController {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    @MutationMapping
    public Author createAuthor(@Argument String firstName, @Argument String lastName) {
        Author author = Author.builder().firstName(firstName).lastName(lastName).build();
        return authorRepository.save(author);
    }

    @MutationMapping
    public Author updateAuthor(@Argument int id, @Argument String firstName, @Argument String lastName) {
        Author author = authorRepository.findById(id).get();
        if (author != null) {
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorRepository.save(author);
        }
        return author;
    }

    @QueryMapping
    public Author getAuthorById(@Argument int id) {
        return authorRepository.findById(id).get();
    }

    @SchemaMapping
    public List<Book> book(Author author) {
        return bookRepository.findByAuthorId(author.getId());
    }
}


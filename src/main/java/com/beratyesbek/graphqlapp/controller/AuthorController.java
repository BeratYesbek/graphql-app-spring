package com.beratyesbek.graphqlapp.controller;

import com.beratyesbek.graphqlapp.models.Author;
import com.beratyesbek.graphqlapp.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AuthorController {

    private AuthorRepository authorRepository;

    @MutationMapping
    public Author createAuthor(@Argument String firstName, @Argument String lastName) {
        Author author = Author.builder().firstName(firstName).lastName(lastName).build();
        return authorRepository.save(author);
    }
}


package com.beratyesbek.graphqlapp.repositories;

import com.beratyesbek.graphqlapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorId(int authorId);
}

package com.beratyesbek.graphqlapp.repositories;

import com.beratyesbek.graphqlapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

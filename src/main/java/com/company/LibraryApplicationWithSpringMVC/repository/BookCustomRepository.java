package com.company.LibraryApplicationWithSpringMVC.repository;

import com.company.LibraryApplicationWithSpringMVC.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookCustomRepository {

    List<Book> findAllByParameters(String search);

    List<Book> getBooks(String name);
}

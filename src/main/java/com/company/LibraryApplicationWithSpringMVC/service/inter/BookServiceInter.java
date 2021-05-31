package com.company.LibraryApplicationWithSpringMVC.service.inter;

import com.company.LibraryApplicationWithSpringMVC.models.Book;

import java.util.List;


public interface BookServiceInter {

    List<Book> getAllBooks(String search);

    List<Book> getBooks(String name);

    boolean addBook(Book book);

    boolean updateBook(Book book);

    Book findById(Integer id);

    boolean remove(Integer id);

    boolean buyBook(Book book);
}

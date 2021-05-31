package com.company.LibraryApplicationWithSpringMVC.service.impl;

import com.company.LibraryApplicationWithSpringMVC.models.Book;
import com.company.LibraryApplicationWithSpringMVC.models.User;
import com.company.LibraryApplicationWithSpringMVC.models.UserBook;
import com.company.LibraryApplicationWithSpringMVC.repository.BookRepository;
import com.company.LibraryApplicationWithSpringMVC.repository.UserBookRepository;
import com.company.LibraryApplicationWithSpringMVC.service.inter.BookServiceInter;
import com.company.LibraryApplicationWithSpringMVC.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServiceInter {


    private final BookRepository bookRepositoryInter;

    private final UserServiceInter userServiceInter;

    private final UserBookRepository userBookRepository;

    @Override
    public List<Book> getAllBooks(String search) {

        return null;
    }

    @Override
    public List<Book> getBooks(String name) {
        return bookRepositoryInter.getBooks(name);
    }

    @Override
    public boolean addBook(Book book) {
        bookRepositoryInter.save(book);
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        if (bookRepositoryInter.existsById(book.getId())) {
            bookRepositoryInter.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> book = bookRepositoryInter.findById(id);
        return book.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean remove(Integer id) {
        if (bookRepositoryInter.existsById(id)) {
            bookRepositoryInter.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean buyBook(Book book) {
        Book b =findById(book.getId());

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();

        UserBook ub = new UserBook();
        User us = userServiceInter.findByEmail(email);
        ub.setUser(us);
        ub.setBook(b);
        Float budget = us.getBudget();
        Float price = book.getPrice();
        if(budget>price&&book.getStockCount()>0) {
            budget -= price;
            us.setBudget(budget);
            userBookRepository.save(ub);
        }
        return true;
    }
}

package com.company.LibraryApplicationWithSpringMVC.repository;

import com.company.LibraryApplicationWithSpringMVC.models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBook,Integer> {
}

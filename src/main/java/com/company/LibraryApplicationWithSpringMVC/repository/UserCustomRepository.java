package com.company.LibraryApplicationWithSpringMVC.repository;

import com.company.LibraryApplicationWithSpringMVC.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserCustomRepository {

    List<User> getAll(String name, String surname);

    User findByEmail(String email);


}

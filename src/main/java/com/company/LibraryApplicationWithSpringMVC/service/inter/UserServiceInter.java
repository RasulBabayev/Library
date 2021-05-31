package com.company.LibraryApplicationWithSpringMVC.service.inter;

import com.company.LibraryApplicationWithSpringMVC.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServiceInter {

    List<User> getAll(String name, String surname);

    boolean addUser(User u);

    boolean deleteUser(Integer id);

    boolean updateUser(User u);

    User getById(Integer id);

    User findByEmail(String email);
}

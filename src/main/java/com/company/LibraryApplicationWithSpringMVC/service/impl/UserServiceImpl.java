package com.company.LibraryApplicationWithSpringMVC.service.impl;

import com.company.LibraryApplicationWithSpringMVC.models.User;
import com.company.LibraryApplicationWithSpringMVC.repository.UserRepository;
import com.company.LibraryApplicationWithSpringMVC.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInter {

    private final UserRepository userRepositoryInter;

    private final PasswordEncoder passwordEncoder;
    @Override
    public boolean addUser(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userRepositoryInter.save(u);
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (userRepositoryInter.existsById(id)) {
            userRepositoryInter.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User u) {
        if (userRepositoryInter.existsById(u.getId())) {
            userRepositoryInter.save(u);

            return true;
        }
        return false;
    }

    @Override
    public User getById(Integer id) {
        Optional<User> user = userRepositoryInter.findById(id);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByEmail(String email) {
        return userRepositoryInter.findByEmail(email);
    }

    @Override
    public List<User> getAll(String name, String surname) {

        return userRepositoryInter.getAll(name, surname);
    }
}

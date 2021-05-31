package com.company.LibraryApplicationWithSpringMVC.repository;

import com.company.LibraryApplicationWithSpringMVC.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserCustomRepository {


}

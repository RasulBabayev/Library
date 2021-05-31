package com.company.LibraryApplicationWithSpringMVC.controller;

import com.company.LibraryApplicationWithSpringMVC.models.Book;
import com.company.LibraryApplicationWithSpringMVC.models.User;
import com.company.LibraryApplicationWithSpringMVC.models.UserBook;
import com.company.LibraryApplicationWithSpringMVC.repository.BookRepository;
import com.company.LibraryApplicationWithSpringMVC.repository.UserBookRepository;
import com.company.LibraryApplicationWithSpringMVC.repository.UserRepository;
import com.company.LibraryApplicationWithSpringMVC.service.inter.BookServiceInter;
import com.company.LibraryApplicationWithSpringMVC.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {



    @GetMapping("/access-denied")
    public String getAccessDenied() {
        return "access-denied";
    }


}

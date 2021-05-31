package com.company.LibraryApplicationWithSpringMVC.controller;


import com.company.LibraryApplicationWithSpringMVC.models.User;
import com.company.LibraryApplicationWithSpringMVC.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInter userServiceInter;

    @GetMapping(value = "/register")
    public String register(Model m) {
        m.addAttribute("user", new User());
        return "user-register";
    }

    @GetMapping(value = "/updateuser/{id}")
    public String update(@PathVariable int id, Model m) {
        User user = userServiceInter.getById(id);
        System.out.println(user);
        m.addAttribute("user", user);
        return "userupdateform";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(User user) {
        userServiceInter.addUser(user);
        return "redirect:/books";
    }

    @RequestMapping(value = "/viewusers")
    public String getAllUsers(Model m,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {
        List<User> list = userServiceInter.getAll(name, surname);
        System.out.println(list);
        m.addAttribute("list", list);
        return "viewusers";
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceInter.updateUser(user);
        return "redirect:/viewusers";
    }

    @RequestMapping(value = "/deleteuser/{id}")
    public String deleteUser(@PathVariable int id) {
        userServiceInter.deleteUser(id);
        return "viewusers";
    }
}

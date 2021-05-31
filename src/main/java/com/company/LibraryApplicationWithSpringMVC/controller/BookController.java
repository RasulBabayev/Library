package com.company.LibraryApplicationWithSpringMVC.controller;

import com.company.LibraryApplicationWithSpringMVC.models.Book;
import com.company.LibraryApplicationWithSpringMVC.models.User;
import com.company.LibraryApplicationWithSpringMVC.models.UserBook;
import com.company.LibraryApplicationWithSpringMVC.repository.BookRepository;
import com.company.LibraryApplicationWithSpringMVC.repository.UserBookRepository;
import com.company.LibraryApplicationWithSpringMVC.service.inter.BookServiceInter;
import com.company.LibraryApplicationWithSpringMVC.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookServiceInter bookServiceInter;

    private final BookRepository bookRepository;

    @GetMapping(value = "/book-edit/{id}")
    public String update(@PathVariable int id, Model m) {
        Book book = bookServiceInter.findById(id);
        System.out.println(book);
        m.addAttribute("book", book);
        return "bookupdateform";
    }

    @GetMapping(value = "/book-add")
    public String add(Model m) {
        m.addAttribute("book", new Book());
        return "book-add";
    }

    @RequestMapping(value = "/book-delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookServiceInter.remove(id);
        return "viewbooks";
    }


    @RequestMapping(value = "/book-add", method = RequestMethod.POST)
    public String addBook(Book book) {
        bookServiceInter.addBook(book);
        return "viewbooks";
    }

    @RequestMapping(value = "/viewbooks")
    public String getAllBooks(Model m,
                              @RequestParam(value = "name", required = false) String name) {
        List<Book> list = bookServiceInter.getBooks(name);
        System.out.println(list);
        m.addAttribute("list", list);
        return "viewbooks";
    }

    @RequestMapping(value = "/book-edit", method = RequestMethod.POST)
    public String bookupdate(@ModelAttribute("book") Book book) {
        bookServiceInter.updateBook(book);
        return "viewbooks";
    }


    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView books(@RequestParam(value = "search", required = false) String search) {

        List<Book> books = bookRepository.findAllByParameters(search);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("books");
        mv.addObject("books", books);
        return mv;
    }

    @RequestMapping(value = "/books")
    public String books() {
        return "books";
    }

    @RequestMapping(value = "/buy-book/{id}", method = RequestMethod.GET)
    public ModelAndView buy(@PathVariable int id) {
        Book book = bookServiceInter.findById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buy");
        modelAndView.addObject("book", book);

        return modelAndView;
    }

    @RequestMapping(value = "/buy-book", method = RequestMethod.POST)
    public String buyBooks(@ModelAttribute("book") Book book) {
       bookServiceInter.buyBook(book);
        return "redirect:/books";
    }

}

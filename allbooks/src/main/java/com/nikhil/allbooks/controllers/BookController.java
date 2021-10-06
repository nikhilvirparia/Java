package com.nikhil.allbooks.controllers;

import com.nikhil.allbooks.models.Book;
import com.nikhil.allbooks.repositories.BookRepository;

import com.nikhil.allbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


@Controller
public class BookController {

    // autowired adds the dependency injection
    @Autowired
    BookRepository bookRepository;
   //BookService bookService;

    private BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }
    @RequestMapping("/books")
    public String index(Model model) {

        List<Book> book = bookService.allBooks();
        model.addAttribute("books", book);

        return "index.jsp";
    }


    @RequestMapping("/show/{id}")
    public String findbook(Model model, @PathVariable("id") Long id) {

        model.addAttribute("books", bookService.findBook(id));

        return "show.jsp";
    }



}

package com.nikhil.renderingbooks.controllers;

import com.nikhil.renderingbooks.models.Book;
import com.nikhil.renderingbooks.repositories.BookRepository;

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

    @RequestMapping("/books/{bookId}")
    public String index(Model model, @PathVariable("bookId") Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);
        model.addAttribute("books", book.get());


        return "index.jsp";
    }



}

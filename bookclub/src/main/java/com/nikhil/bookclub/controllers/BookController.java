package com.nikhil.bookclub.controllers;

import com.nikhil.bookclub.models.Book;
import com.nikhil.bookclub.models.User;
import com.nikhil.bookclub.services.BookService;
import com.nikhil.bookclub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
   @Autowired
    private UserService userService;

    @RequestMapping("/books")
    public String index(Model model, HttpSession session) {
        if(session.getAttribute("user_id") == null)
            return "redirect:/";
        Long userId = (Long) session.getAttribute("user_id");
        User user = userService.findUser(userId);
        List<Book> books = bookService.allBooks();
        model.addAttribute("user", user);
        model.addAttribute("books", books);
        return "dashboard.jsp";
    }

    @RequestMapping("books/{id}")
    public String single(Model model, HttpSession session, @PathVariable("id") Long id) {
        if(session.getAttribute("user_id") == null)
            return "redirect:/";
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        Long userId = (Long) session.getAttribute("user_id");
        User user = userService.findUser(userId);
        model.addAttribute("user", user);
        return "books.jsp";
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
        if(session.getAttribute("user_id") == null)
            return "redirect:/";
        Long userId = (Long) session.getAttribute("user_id");
        User user = userService.findUser(userId);
        model.addAttribute("user", user);
        return "new.jsp";
    }

    @RequestMapping(value="/books", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping("/edit/{id}")
    public String edit(HttpSession session, @PathVariable("id") Long id, Model model) {
        if(session.getAttribute("user_id") == null)
            return "redirect:/";
        Long userId = (Long) session.getAttribute("user_id");
        User user = userService.findUser(userId);
        model.addAttribute("user", user);
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/home";
    }
}

package com.nikhil.allbooks.controllers;

import com.nikhil.allbooks.services.BookService;
import com.nikhil.allbooks.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksApi {

    private final BookService bookService;

    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }

    // create the books
    @RequestMapping(value="/api/books", method= RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title,
                       @RequestParam(value="description") String desc,
                       @RequestParam(value="language") String lang,
                       @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    // Show all the movies
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }

    // Method to update a book
    @RequestMapping(value="/api/books/{id}", method= RequestMethod.PUT)
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }

    // Method to delete a book
    @RequestMapping(value="/api/destroy/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}

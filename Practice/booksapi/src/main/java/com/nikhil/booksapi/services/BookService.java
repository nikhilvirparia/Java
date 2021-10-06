package com.nikhil.booksapi.services;

import com.nikhil.booksapi.repositories.BookRepository;
import org.springframework.stereotype.Service;
import com.nikhil.booksapi.models.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    //Update Book
    public Book updateBook(Long id, String title, String description, String language, Integer pages) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(title);
            book.setDescription(description);
            book.setLanguage(language);
            book.setNumberOfPages(pages);

            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    // delete a book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}


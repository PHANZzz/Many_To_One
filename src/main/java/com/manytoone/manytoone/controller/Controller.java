package com.manytoone.manytoone.controller;

import com.manytoone.manytoone.model.Author;
import com.manytoone.manytoone.model.Book;
import com.manytoone.manytoone.repository.AuthorRepository;
import com.manytoone.manytoone.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Controller(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @PostMapping("/books")
    public Book createBooks(@RequestBody Book books){
        Author author=authorRepository.save(books.getAuthor());
        books.setAuthor(author);
        return bookRepository.save(books);

    }
    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }
    @GetMapping("/books")
    public List<Book>getAllBooks(){
        return bookRepository.findAll();
    }
    @GetMapping("/author")
    public List<Author>getAllAuthors(){
        return authorRepository.findAll();
    }

}

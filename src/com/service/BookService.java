package com.service;

import com.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book b);
    void deleteBook(int id);
    List<Book> getAllBooks();
}

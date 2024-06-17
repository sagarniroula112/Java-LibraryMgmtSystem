package com.service;

import com.model.Book;

import java.util.List;

public interface BookServices {
    void addBook(Book b);
    void removeBook(int id);
    List<Book> getAllBooks();
}

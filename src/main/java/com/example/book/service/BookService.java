package com.example.book.service;

import com.example.book.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
}

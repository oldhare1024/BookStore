package com.example.book.service.impl;

import com.example.book.dao.BookDAO;
import com.example.book.pojo.Book;
import com.example.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }
}

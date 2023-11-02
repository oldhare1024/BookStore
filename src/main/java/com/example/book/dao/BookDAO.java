package com.example.book.dao;

import com.example.book.pojo.Book;

import java.util.List;

public interface BookDAO {
    //List<Book> getBookList(Integer minPrice,Integer maxPrice,Integer pageNo);
    List<Book> getBookList();

}

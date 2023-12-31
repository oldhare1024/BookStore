package com.example.book.dao.impl;

import com.example.book.dao.BookDAO;
import com.example.book.pojo.Book;
import com.example.myssm.basedao.BaseDAO;

import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus=0");
    }
    public Book getBook(Integer id){
        return load("select * from t_book where bid = ? ",id);
    }
}

package com.example.book.dao;

import com.example.book.pojo.User;

public interface UserDAO {
    User getUser(String uname,String pwd);
}

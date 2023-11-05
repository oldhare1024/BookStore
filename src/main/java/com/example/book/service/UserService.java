package com.example.book.service;

import com.example.book.pojo.User;

public interface UserService {
    User login(String uname, String pwd);

    void regist(User user);
}

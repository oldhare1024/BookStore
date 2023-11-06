package com.example.book.service.impl;

import com.example.book.dao.UserDAO;
import com.example.book.pojo.User;
import com.example.book.service.UserService;

public class UserServiceImpl implements UserService {
   private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        return userDAO.getUser(uname);
    }
}


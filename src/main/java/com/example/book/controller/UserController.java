package com.example.book.controller;

import com.example.book.pojo.User;
import com.example.book.service.BookService;
import com.example.book.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {
    private UserService userService;
    private BookService bookService;
    public String login(String uname, String pwd, HttpSession session) {
        User user=userService.login(uname,pwd);
        if(user!=null){
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }
        else {
            return "user/login";
        }
    }
}

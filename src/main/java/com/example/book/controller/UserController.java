package com.example.book.controller;

import com.example.book.pojo.Cart;
import com.example.book.pojo.User;
import com.example.book.service.CartItemService;
import com.example.book.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {
    private UserService userService;
    private CartItemService cartItemService;
    public String login(String uname, String pwd, HttpSession session) {
        User user=userService.login(uname,pwd);
        if(user!=null){
            Cart cart=cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }
        else {
            return "user/login";
        }
    }
}

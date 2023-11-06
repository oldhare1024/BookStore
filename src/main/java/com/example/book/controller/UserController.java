package com.example.book.controller;

import com.example.book.pojo.Cart;
import com.example.book.pojo.User;
import com.example.book.service.CartItemService;
import com.example.book.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

    public String regist(String uname, String pwd, String email, String verifyCode, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object kaptchaCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (kaptchaCodeObj == null || !verifyCode.equals(kaptchaCodeObj)) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            //out.println("<script language='javascript'>alert('验证码不正确!');window.location.href='page.do?operate=page&page=user/regist';</script>");
            out.println("<script language='javascript'>alert('验证码不正确!');</script>");
            return "user/regist";
        } else {
            userService.regist(new User(uname, pwd, email, 0));
            return "user/login";
        }
    }

    public String ckUname(String uname) {
        User user = userService.getUser(uname);
        if (user != null) {//用户名被占用
            return "json:{'uname':'1'}";
        } else {//用户名可以注册
            return "json:{'uname':'0'}";
        }
    }
}

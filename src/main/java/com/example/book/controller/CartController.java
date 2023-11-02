package com.example.book.controller;

import com.example.book.pojo.Book;
import com.example.book.pojo.CartItem;
import com.example.book.pojo.User;
import com.example.book.service.CartItemService;

import javax.servlet.http.HttpSession;

public class CartController {
    private CartItemService cartItemService;
    public String addCart(Integer bookId, HttpSession session){
        User user=(User)session.getAttribute("currUser");
        CartItem cartItem=new CartItem(new Book(bookId),1,user);
        cartItemService.addOrupdateCartItem(cartItem,user.getCart());
        return "redirect:card.do";
    }
}

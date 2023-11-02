package com.example.book.dao;

import com.example.book.pojo.CartItem;
import com.example.book.pojo.User;

import java.util.List;

public interface CartItemDAO {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    List<CartItem> getCartItemList(User user);
}

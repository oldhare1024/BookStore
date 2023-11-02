package com.example.book.dao;

import com.example.book.pojo.CartItem;

public interface CartItemDAO {
    void addCartItem(CartItem carItem);
    void updateCartItem(CartItem cartItem);
}

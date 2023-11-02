package com.example.book.service;

import com.example.book.pojo.Cart;
import com.example.book.pojo.CartItem;
import com.example.book.pojo.User;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrupdateCartItem(CartItem cartItem, Cart cart);
    Cart getCart(User user);
}

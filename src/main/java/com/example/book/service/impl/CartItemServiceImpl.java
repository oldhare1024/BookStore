package com.example.book.service.impl;

import com.example.book.dao.CartItemDAO;
import com.example.book.pojo.CartItem;
import com.example.book.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
    private CartItemDAO cartItemDAO;
    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem) {
        c
    }
}

package com.example.book.service;

import com.example.book.pojo.Cart;
import com.example.book.pojo.CartItem;
import com.example.book.pojo.User;

import java.util.List;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrupdateCartItem(CartItem cartItem, Cart cart);
    //获取指定用户的所有购物车项列表(查询时，会将book的详细信息设置进去)
    List<CartItem> getCartItemList(User user);
    Cart getCart(User user);
}

package com.example.book.service.impl;

import com.example.book.dao.CartItemDAO;
import com.example.book.pojo.Book;
import com.example.book.pojo.Cart;
import com.example.book.pojo.CartItem;
import com.example.book.pojo.User;
import com.example.book.service.BookService;
import com.example.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItemServiceImpl implements CartItemService {
    private CartItemDAO cartItemDAO;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrupdateCartItem(CartItem cartItem, Cart cart) {
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if(cartItemMap==null){
                cartItemMap=new HashMap<>();
            }
            if(cartItemMap.containsKey(cartItem.getBook().getBid())){
                CartItem cartItemTemp=cartItemMap.get(cartItem.getBook().getBid());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount()+1);
                updateCartItem(cartItemTemp);
            }else {
                addCartItem(cartItem);
            }
        }
        else {
            addCartItem(cartItem);
        }
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList=cartItemDAO.getCartItemList(user);
        for(CartItem cartItem:cartItemList){
            Book book=bookService.getBook(cartItem.getBook().getBid());
            cartItem.setBook(book);
        }
        return cartItemList;
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList=getCartItemList(user);
        Map<Integer,CartItem> cartItemMap =new HashMap<>();
        for(CartItem cartItem:cartItemList){
            cartItemMap.put(cartItem.getBook().getBid(),cartItem);
        }
        Cart cart=new Cart();
        cart.setCartItemMap(cartItemMap);

        return cart;
    }
}

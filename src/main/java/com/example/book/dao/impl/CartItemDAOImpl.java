package com.example.book.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.example.book.dao.CartItemDAO;
import com.example.book.pojo.CartItem;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem carItem) {
        executeQuery("insert into t_cart_item values(0,?,?,?)",carItem.getBook().getBid(),carItem.getBuyCount(),carItem.getUserBean().getUid());
    }
    public void updateCartItem(CartItem cartItem){
        executeUpdate("update t_cart_item set buyCount = ? where id = ? ",cartItem.getBuyCount(),cartItem.getCid());
    }
}

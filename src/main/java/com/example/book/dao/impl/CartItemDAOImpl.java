package com.example.book.dao.impl;

import com.example.book.dao.CartItemDAO;
import com.example.book.pojo.CartItem;
import com.example.book.pojo.User;
import com.example.myssm.basedao.BaseDAO;

import java.util.List;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        executeUpdate("insert into t_cart_item values(0,?,?,?)",cartItem.getBook().getBid(),cartItem.getBuyCount(),cartItem.getUserBean().getUid());
    }
    public void updateCartItem(CartItem cartItem){
        executeUpdate("update t_cart_item set buyCount = ? where cid = ? ",cartItem.getBuyCount(),cartItem.getCid());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean = ? ",user.getUid());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        super.executeUpdate("delete from t_cart_item where cid = ?",cartItem.getCid());
    }
}

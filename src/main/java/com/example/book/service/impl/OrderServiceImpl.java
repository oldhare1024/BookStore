package com.example.book.service.impl;

import com.example.book.dao.CartItemDAO;
import com.example.book.dao.OrderDAO;
import com.example.book.dao.OrderItemDAO;
import com.example.book.pojo.CartItem;
import com.example.book.pojo.OrderBean;
import com.example.book.pojo.OrderItem;
import com.example.book.pojo.User;
import com.example.book.service.OrderService;

import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderDAO.addOrderBean(orderBean);
        User currUser=orderBean.getOrderUser();
        Map<Integer,CartItem> cartItemMap=currUser.getCart().getCartItemMap();
        OrderItem orderItem=new OrderItem();
        for(CartItem cartItem:cartItemMap.values()){
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }
        for(CartItem cartItem:cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }
    }
}

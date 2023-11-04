package com.example.book.service;

import com.example.book.pojo.OrderBean;
import com.example.book.pojo.User;

import java.util.List;

public interface OrderService {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
}

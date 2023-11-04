package com.example.book.dao;

import com.example.book.pojo.OrderBean;
import com.example.book.pojo.User;

import java.util.List;

public interface OrderDAO {
    void addOrderBean(OrderBean orderBean);
    //获取指定用户订单列表
    List<OrderBean> getOrderList(User user);
    Integer getOrderTotalBookCount(OrderBean orderBean);
}

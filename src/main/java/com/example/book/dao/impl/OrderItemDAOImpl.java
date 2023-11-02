package com.example.book.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.example.book.dao.OrderItemDAO;
import com.example.book.pojo.OrderItem;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        super.executeUpdate("insert into t_order_item value(0,?,?,?)",orderItem.getBook().getBid(),orderItem.getBuyCount(),orderItem.getOrderBean().getOid());
    }
}

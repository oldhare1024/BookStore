package com.example.book.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.example.book.dao.OrderDAO;
import com.example.book.pojo.OrderBean;

public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId=super.executeUpdate("insert into t_order values(0,?,?,?,?,?)",orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser().getUid(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        orderBean.setOid(orderBeanId);
    }
}

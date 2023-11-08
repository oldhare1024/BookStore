package com.example.book.dao.impl;

import com.example.book.dao.OrderDAO;
import com.example.book.pojo.OrderBean;
import com.example.book.pojo.User;
import com.example.myssm.basedao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId=super.executeUpdate("insert into t_order values(0,?,?,?,?,?)",orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser().getUid(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        orderBean.setOid(orderBeanId);
    }
    @Override
    public List<OrderBean> getOrderList(User user) {
        return executeQuery("select * from t_order where orderUser = ?",user.getUid());
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql="SELECT SUM(t3.buyCount) AS totalBookCount , t3.orderBean FROM\n" +
                "(\n" +
                "SELECT t1.oid,t2.buyCount,t2.orderBean FROM t_order t1 INNER JOIN t_order_item t2\n" +
                "ON t1.oid=t2.orderBean WHERE t1.orderUser =?\n" +
                ") t3 GROUP BY t3.orderBean HAVING t3.orderBean=?;";
        return ((BigDecimal)executeComplexQuery(sql,orderBean.getOrderUser().getUid(),orderBean.getOid())[0]).intValue();
    }
}

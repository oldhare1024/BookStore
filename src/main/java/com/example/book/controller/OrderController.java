package com.example.book.controller;

import com.example.book.pojo.OrderBean;
import com.example.book.pojo.User;
import com.example.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderController {
    private OrderService orderService;
    public String checkout(HttpSession session){
        OrderBean orderBean=new OrderBean();
        Date now=new Date();
        int year=now.getYear()+1900;
        int month=now.getMonth();
        int day=now.getDate();
        int hour=now.getHours();
        int min=now.getMinutes();
        int sec=now.getSeconds();
        orderBean.setOrderNo(UUID.randomUUID().toString()+"_"+year+month+day+hour+min+sec);
        orderBean.setOrderDate(now);
        User user=(User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderService.addOrderBean(orderBean);
        return "index";
    }
    public String getOrderList(HttpSession session){
        User user=(User)session.getAttribute("currUser");
        List<OrderBean> orderList=orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser",user);
        return "order/order";
    }
}

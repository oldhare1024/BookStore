package com.example.book.pojo;

public class OrderItem {
    private Integer ooid;
    private Book book;
    private Integer buyCount;
    private OrderBean orderBean;

    public OrderItem(){

    }

    public OrderItem(Integer ooid) {
        this.ooid = ooid;
    }

    public Integer getOoid() {
        return ooid;
    }

    public void setOoid(Integer ooid) {
        this.ooid = ooid;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }
}

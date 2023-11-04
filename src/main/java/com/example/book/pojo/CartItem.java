package com.example.book.pojo;

import java.math.BigDecimal;

public class CartItem {
    private Integer cid;
    private Book book;
    private Integer buyCount;
    private User userBean;
    private Double xj;

    public CartItem(){

    }

    public CartItem(Integer cid, Integer buyCount) {
        this.cid = cid;
        this.buyCount = buyCount;
    }

    public CartItem(Book book, Integer buyCount, User userBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
    }

    public CartItem(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public Double getXj() {
        BigDecimal bigDecimalPrice = new BigDecimal("" + getBook().getPrice());
        BigDecimal bigDecimalBuyCount = new BigDecimal("" + buyCount);
        BigDecimal bigDecimalXJ = bigDecimalPrice.multiply(bigDecimalBuyCount);
        xj = bigDecimalXJ.doubleValue();
        return xj;
    }
}

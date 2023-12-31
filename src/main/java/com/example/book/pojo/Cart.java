package com.example.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Integer, CartItem> cartItemMap;
    private Double totalMoney;
    private Integer totalCount;//购物车内书的种类数
    private Integer totalBookCount;//购物车内书的总数量

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        BigDecimal bigDecimalTotalMoney = BigDecimal.ZERO;
        BigDecimal bigDecimalPrice = BigDecimal.ZERO;
        BigDecimal bigDecimalBuyCount = BigDecimal.ZERO;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> cartItemEntry : entries) {
                CartItem cartItem = cartItemEntry.getValue();
                bigDecimalPrice = new BigDecimal("" + cartItem.getBook().getPrice());
                bigDecimalBuyCount = new BigDecimal("" + cartItem.getBuyCount());
//                bigDecimalTotalMoney = bigDecimalTotalMoney + bigDecimalPrice * bigDecimalBuyCount;
                bigDecimalTotalMoney = bigDecimalTotalMoney.add(bigDecimalPrice.multiply(bigDecimalBuyCount));
            }
        }
        totalMoney = bigDecimalTotalMoney.doubleValue();
        return totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem cartItem : cartItemMap.values()) {
                totalBookCount = totalBookCount + cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }
}

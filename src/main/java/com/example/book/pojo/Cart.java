package com.example.book.pojo;

import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Integer,CartItem> cartItemMap;
    private Double totalMoney;
    private Integer totalCount;
    public Cart(){}
    public Map<Integer,CartItem>getCartItemMap(){
        return cartItemMap;
    }
    public void setCartItemMap(Map<Integer,CartItem> cartItemMap){
        this.cartItemMap=cartItemMap;
    }
    public Double getTotalMoney(){
        totalMoney=0.0;
        if(cartItemMap!=null&&cartItemMap.size()>0){
            Set<Map.Entry<Integer,CartItem>>entries=cartItemMap.entrySet();
            for(Map.Entry<Integer,CartItem> cartItemEntry:entries){
                CartItem cartItem=cartItemEntry.getValue();
                totalMoney=cartItem.getBook().getPrice()*cartItem.getBuyCount();
            }
        }
        return totalMoney;
    }
    public Integer getTotalCount(){
        totalCount=0;
        if(cartItemMap!=null&&cartItemMap.size()>0){
            totalCount=cartItemMap.size();
        }
        return totalCount;
    }
}

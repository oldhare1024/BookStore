package com.example.book.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.example.book.dao.UserDAO;
import com.example.book.pojo.User;

public class UserDaoImpl extends BaseDAO<User> implements UserDAO {
    public User getUser(String uname, String pwd) {
        return load("select * from t_user where uname like ? and pwd like ?", uname, pwd);
    }

    @Override
    public void addUser(User user) {
        executeUpdate("insert into t_user values(0,?,?,?,0)", user.getUname(), user.getPwd(), user.getEmail());
    }
}

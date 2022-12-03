package com.zejing.book.dao.Impl;

import com.zejing.book.dao.UserDAO;
import com.zejing.book.pojo.User;
import com.zejing.myssm.basedao.BaseDAO;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return load("select *from t_user where uname like ? and pwd like ?",uname,pwd);
    }
}

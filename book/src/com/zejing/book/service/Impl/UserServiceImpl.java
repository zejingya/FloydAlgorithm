package com.zejing.book.service.Impl;

import com.zejing.book.dao.UserDAO;
import com.zejing.book.pojo.User;
import com.zejing.book.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }
}

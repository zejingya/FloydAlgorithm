package com.zejing.book.dao;

import com.zejing.book.pojo.User;

public interface UserDAO {
    User getUser(String uname,String pwd);
}

package com.zejing.mybatis.mappers;

import com.zejing.mybatis.pojo.User;

public interface UserMapper {

    int insertUser();

    int updateUser();

    User getUserById();
}

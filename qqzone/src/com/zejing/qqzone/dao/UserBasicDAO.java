package com.zejing.qqzone.dao;

import com.zejing.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDAO {

    //根据账号和密码获取用户信息
    UserBasic getUserBasic(String loginId , String password) ;

    //获取好友列表
    List<UserBasic> friendIdList(UserBasic userBasic) ;

    //根据id查询信息
    UserBasic getByUserBasicId(Integer id);
}

package com.zejing.qqzone.service;

import com.zejing.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {

    //登录服务
    UserBasic login(String loginId,String password);

    //获取好友列表
    List<UserBasic> getFriendList(UserBasic userBasic);

    UserBasic getUserBasicById(Integer id);
}

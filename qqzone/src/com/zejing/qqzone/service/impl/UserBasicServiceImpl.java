package com.zejing.qqzone.service.impl;

import com.zejing.qqzone.dao.UserBasicDAO;
import com.zejing.qqzone.pojo.UserBasic;
import com.zejing.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

public class UserBasicServiceImpl implements UserBasicService {

    private UserBasicDAO userBasicDAO = null;


    @Override
    public UserBasic login(String loginId, String password) {//登录

        UserBasic userBasic = userBasicDAO.getUserBasic(loginId, password);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {//登录后，获取旁边的好友列表以显示

        List<UserBasic> userBasics = userBasicDAO.friendIdList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasics.size());

        for (int i = 0; i < userBasics.size(); i++) {
            friendList.add(userBasicDAO.getByUserBasicId(userBasics.get(i).getId()));//希望未来看到这不会生气。
            // UserBasic friend = userBasicList.get(i);
            //            friend = userBasicDAO.getUserBasicById(friend.getId());
            //            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDAO.getByUserBasicId(id);
    }
}

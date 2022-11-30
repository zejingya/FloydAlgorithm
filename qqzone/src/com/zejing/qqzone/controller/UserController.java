package com.zejing.qqzone.controller;

import com.zejing.qqzone.pojo.Topic;
import com.zejing.qqzone.pojo.UserBasic;
import com.zejing.qqzone.service.TopicService;
import com.zejing.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {

    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String password, HttpSession Session) {

        UserBasic userBasic = userBasicService.login(loginId, password);


        if (userBasic != null) {

            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            Session.setAttribute("userBasic",userBasic);//保存登陆者的信息
            Session.setAttribute("friend",userBasic);//为了验证是谁的空间,如果上下二者key相同，则说明在自己的空间



            return "index";
        } else {
            return "login";
        }
    }

    public String friend(Integer id,HttpSession Session) {

        //根据id获取用户信息
        UserBasic currFriend = userBasicService.getUserBasicById(id);

        List<Topic> topicList = topicService.getTopicList(currFriend);

        currFriend.setTopicList(topicList);

        Session.setAttribute("friend",currFriend);

        return "index";


    }


}

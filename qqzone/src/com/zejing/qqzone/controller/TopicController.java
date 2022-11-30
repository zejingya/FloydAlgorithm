package com.zejing.qqzone.controller;

import com.zejing.qqzone.pojo.Topic;
import com.zejing.qqzone.pojo.UserBasic;
import com.zejing.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class TopicController {

    private TopicService topicService;

    public String topicDetail(Integer id, HttpSession session) {

        Topic topic = topicService.getTopicById(id);

        session.setAttribute("topic",topic);

        return "frames/detail";
    }

    public String delTopic(Integer topicId) {

        topicService.delTopic(topicId);
        //刷新页面
        return "redirect:topic.do?operate=getTopicList";
    }

    public String getTopicList(HttpSession session) {

        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");

        List<Topic> topicList = topicService.getTopicList(userBasic);
        //重新设置日志列表
        userBasic.setTopicList(topicList);

        session.setAttribute("friend",userBasic);

        return "frames/main";

    }
}

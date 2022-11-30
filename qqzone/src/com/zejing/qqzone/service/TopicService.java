package com.zejing.qqzone.service;

import com.zejing.qqzone.pojo.Topic;
import com.zejing.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {//内容的服务

    //查询用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);

    //根据id查询topic
    Topic getTopicById(Integer id);

    //根据id获取指定topic信息，包含作者信息
    Topic getTopic(Integer id);

    void delTopic(Integer id);

}

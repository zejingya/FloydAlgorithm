package com.zejing.qqzone.dao;

import com.zejing.qqzone.pojo.Topic;
import com.zejing.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {

    //获取指定用户的所有日志
    List<Topic> getTopicList(UserBasic userBasic);

    //添加日志
    void addTopic(Topic topic);

    //删除日志
    void delTopic(Topic topic);

    //点击超链接后获取信息
    Topic getTopic(Integer id);
}

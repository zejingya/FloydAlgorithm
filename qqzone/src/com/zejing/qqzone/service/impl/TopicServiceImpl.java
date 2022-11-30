package com.zejing.qqzone.service.impl;

import com.zejing.qqzone.dao.TopicDAO;
import com.zejing.qqzone.pojo.Reply;
import com.zejing.qqzone.pojo.Topic;
import com.zejing.qqzone.pojo.UserBasic;
import com.zejing.qqzone.service.ReplyService;
import com.zejing.qqzone.service.TopicService;
import com.zejing.qqzone.service.UserBasicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO;
    private ReplyService replyService;
    private UserBasicService userBasicService;


    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    //根据id获取指定topic信息，包含作者信息
    public Topic getTopic(Integer id) {

        Topic topic = topicDAO.getTopic(id);

        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);

        return topic;
    }

    @Override
    public void delTopic(Integer id) {

        Topic topic = topicDAO.getTopic(id);

        if (topic != null) {

            replyService.delAllReply(topic);
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public Topic getTopicById(Integer id) {

        Topic topic = getTopic(id);

        List<Reply> replyList = replyService.getReplyListById(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }
}

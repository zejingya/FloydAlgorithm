package com.zejing.qqzone.service;

import com.zejing.qqzone.pojo.Reply;
import com.zejing.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {
    //根据topic的id获取关联的所有回复
    List<Reply> getReplyListById(Integer topicId);

    //添加回复
    void addReply(Reply reply);

    void delReply(Integer replyId);

    //删除一个topic种所有reply
    void delAllReply(Topic topic);
}

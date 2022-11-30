package com.zejing.qqzone.dao;

import com.zejing.qqzone.pojo.HostReply;

public interface HostReplyDAO {

    //根据replyId查询关联的主人回复
    HostReply getHostReplyByReplyId(Integer replyId);

    void delHostReply(Integer replyId);
}

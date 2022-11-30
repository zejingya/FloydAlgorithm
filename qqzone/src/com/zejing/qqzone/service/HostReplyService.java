package com.zejing.qqzone.service;

import com.zejing.qqzone.pojo.HostReply;

public interface HostReplyService {

    HostReply getHostReplyByReplyId(Integer replyId);

    void delHostRelpy(Integer replyId);
}

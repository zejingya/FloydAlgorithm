package com.zejing.qqzone.service.impl;

import com.zejing.qqzone.dao.HostReplyDAO;
import com.zejing.qqzone.pojo.HostReply;
import com.zejing.qqzone.service.HostReplyService;

public class HostReplyServiceImpl implements HostReplyService {

    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {

        return hostReplyDAO.getHostReplyByReplyId(replyId);

    }

    @Override
    public void delHostRelpy(Integer replyId) {

        hostReplyDAO.delHostReply(replyId);
    }
}

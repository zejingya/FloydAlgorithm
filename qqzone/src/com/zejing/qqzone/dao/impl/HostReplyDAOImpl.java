package com.zejing.qqzone.dao.impl;

import com.zejing.myssm.basedao.BaseDAO;
import com.zejing.qqzone.dao.HostReplyDAO;
import com.zejing.qqzone.pojo.HostReply;

public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return load("select * from t_host_reply where reply = ?",replyId);
    }

    @Override
    public void delHostReply(Integer replyId) {

        executeQuery("delect from t_host_reply where reply = ?",replyId);
    }
}

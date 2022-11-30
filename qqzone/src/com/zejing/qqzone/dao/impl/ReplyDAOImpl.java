package com.zejing.qqzone.dao.impl;

import com.zejing.myssm.basedao.BaseDAO;
import com.zejing.qqzone.dao.ReplyDAO;
import com.zejing.qqzone.pojo.Reply;
import com.zejing.qqzone.pojo.Topic;

import java.util.List;

public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        return executeQuery("select * from t_reply where topic = ?",topic.getId());
    }

    @Override
    public void addReply(Reply reply) {

        executeQuery("insert into t_reply values(0,?,?,?,?)",reply.getContent(),reply.getReplyDate(),reply.getAuthor().getId(),reply.getTopic().getId());
    }

    @Override
    public void delReply(Integer id) {

        executeQuery("delect from t_reply where id = ?",id);
    }

    @Override
    public Reply getReply(Integer id) {

        return load("select * from t_reply where id = ?",id);
    }
}

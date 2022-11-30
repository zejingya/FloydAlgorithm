package com.zejing.qqzone.dao.impl;

import com.zejing.myssm.basedao.BaseDAO;
import com.zejing.qqzone.dao.TopicDAO;
import com.zejing.qqzone.pojo.Topic;
import com.zejing.qqzone.pojo.UserBasic;

import java.util.List;

public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return executeQuery("select * from t_topic where author = ?",userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Topic topic) {

       executeQuery("delect from t_topic where id = ?",topic.getId());

    }

    @Override
    public Topic getTopic(Integer id) {
        return  load("select * from t_topic where id = ? ",id);
    }
}

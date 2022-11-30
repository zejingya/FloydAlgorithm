package com.zejing.qqzone.service.impl;

import com.zejing.qqzone.dao.ReplyDAO;
import com.zejing.qqzone.pojo.*;
import com.zejing.qqzone.service.*;
import java.util.List;

public class ReplyServiceImpl implements ReplyService {

    private ReplyDAO replyDAO;
    //此处引入的是其他POJO对应的Service接口，而不是DAO接口
    //其他POJO对应的业务逻辑是封装在service层的，我需要调用别人的业务逻辑方法，而不要去深入考虑人家内部的细节
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListById(Integer topicId) {

        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));

        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);

            //设置作者信息
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);

            //设置关联的主人回复
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }

        return replyList;

    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer replyId) {

        Reply reply = replyDAO.getReply(replyId);
        if(reply != null) {

            HostReply hostReply = hostReplyService.getHostReplyByReplyId(replyId);

            if (hostReply != null) {
                hostReplyService.delHostRelpy(hostReply.getId());
            }
        replyDAO.delReply(replyId);

        }
    }

    @Override
    public void delAllReply(Topic topic) {

        List<Reply> replyList = replyDAO.getReplyList(topic);
        
        if (replyList != null) {

            for (Reply reply: replyList) {

                delReply(reply.getId());
            }
        }
    }
}

package com.zejing.qqzone.controller;

import com.zejing.qqzone.pojo.Reply;
import com.zejing.qqzone.pojo.Topic;
import com.zejing.qqzone.pojo.UserBasic;
import com.zejing.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;


public class ReplyController {

    private ReplyService replyService;

    public String addReply(String context,Integer topicId,HttpSession session) {

        UserBasic author = (UserBasic)session.getAttribute("userBasic");
        Reply reply = new Reply(context,new Date(),author,new Topic(topicId));

        replyService.addReply(reply);

        return "redirect:topic.do?operate=topicDatail&id=" + topicId;
    }

    public String delReply(Integer replyId,Integer topicId) {//或者通过session获取topicId参数

        replyService.delReply(replyId);

        //session.getAttribute("topicId");


        return "redirect:topic.do?operate=topicDatail&id=" + topicId;
    }
}
